package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.User;

public interface UserService {

    public User create(User user, UserRole userRole);
    public void autenticateUser(User user);
    public User update(User user);
    public User findById(String id);

}
