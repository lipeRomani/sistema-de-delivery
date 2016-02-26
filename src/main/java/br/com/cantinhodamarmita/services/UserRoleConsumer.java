package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.User;

import java.util.Arrays;

public class UserRoleConsumer implements UserRole {
    @Override
    public User apply(User user) {
        user.getRoles().add(User.Roles.ROLE_CONSUMER);
        return user;
    }
}
