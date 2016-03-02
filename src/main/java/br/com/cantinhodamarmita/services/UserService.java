package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.User;

public interface UserService {

    public User createUser(User user, UserRole userRole);
    public void autenticateUser(User user);

}
