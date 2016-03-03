package br.com.cantinhodamarmita.validators;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CurrentPasswordValidator implements ConstraintValidator<CurrentPassword, String> {


    private String errorMsg;

    @Override
    public void initialize(CurrentPassword currentPassword) {
        errorMsg = currentPassword.message();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        String olderPassword = getPasswordFromLoggedUser();
        return new BCryptPasswordEncoder().matches(password,olderPassword);
    }

    private String getPasswordFromLoggedUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String password =  ((UserDetails) principal).getPassword();
            return password;
        }
        return "";
    }
}
