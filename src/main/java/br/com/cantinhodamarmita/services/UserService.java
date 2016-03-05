package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.UpdatePasswordDto;
import br.com.cantinhodamarmita.entitys.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    public User create(User user, UserRole userRole);
    public void autenticateUser(User user);
    public User update(User user);
    public User findById(String id);
    void changeSecret(UpdatePasswordDto dto);
    public boolean remove(User user, HttpServletRequest request, HttpServletResponse response);
}
