package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.repositories.UserRepository;
import br.com.cantinhodamarmita.validators.UniqueValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService, UniqueValidatorService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user, UserRole userRole) {
        user = userRole.apply(user);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public User getUniqueEntity(String field) {
        return userRepository.findByEmail(field);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s);
    }
}
