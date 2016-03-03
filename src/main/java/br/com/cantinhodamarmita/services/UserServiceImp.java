package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.daos.UserDao;
import br.com.cantinhodamarmita.entitys.UpdatePasswordDto;
import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.exceptions.AuthenticationCredentialsNotPresent;
import br.com.cantinhodamarmita.validators.UniqueValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService, UniqueValidatorService, UserDetailsService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
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
}
