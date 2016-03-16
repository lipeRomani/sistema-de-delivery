package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.daos.UserDao;
import br.com.cantinhodamarmita.entitys.Address;
import br.com.cantinhodamarmita.entitys.AddressDto;
import br.com.cantinhodamarmita.entitys.UpdatePasswordDto;
import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.exceptions.AuthenticationCredentialsNotPresent;
import br.com.cantinhodamarmita.validators.UniqueValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService, UniqueValidatorService, UserDetailsService {

    private UserDao userDao;
    private AddressService addressService;

    @Autowired
    public UserServiceImp(UserDao userDao, AddressService addressService) {
        this.userDao = userDao;
        this.addressService = addressService;
    }

    @Override
    public User create(User user, UserRole userRole) {
        user = userRole.apply(user);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public void autenticateUser(User user) {

        if(user.getEmail() == null || user.getPassword() == null)
            throw new AuthenticationCredentialsNotPresent("Email ou senha são nulos");

        Authentication token = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(token);
    }

    @Override
    public User update(User user) {
        user = userDao.update(user);
        autenticateUser(user); //refresh Principal in security context
        return user;
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void changeSecret(UpdatePasswordDto dto) {
        dto.setNewPassword(new BCryptPasswordEncoder().encode(dto.getNewPassword()));
        User principal = getPrincipal();
        User user = userDao.updatePassword(dto, principal.getId());
        autenticateUser(user); //Refresh Principal in security context
    }

    @Override
    public boolean remove(User user, HttpServletRequest request, HttpServletResponse response) {
        boolean deleted = userDao.delete(user);
        if(deleted){
            logout(request,response);
        }
        return deleted;
    }

    @Override
    public void addAdress(User user, AddressDto addressDto) {
        Address address = addressService.getAddressFrom(addressDto);
        List<Address> addresses = user.getAddresses();
        if(addresses != null){
            addresses.add(address);
        }else{
            addresses = Arrays.asList(address);
        }
        user.setAddresses(addresses);
        userDao.save(user);
    }

    @Override
    public boolean removeAddress(User user, int addressPosition) {
        user = userDao.findById(user.getId());
        user.getAddresses().remove(addressPosition);
        user = userDao.save(user);
        return user != null;
    }

    @Override
    public User getUniqueEntity(String field) {
        return userDao.findByEmail(field);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByEmail(s);
    }

    private User getPrincipal(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
