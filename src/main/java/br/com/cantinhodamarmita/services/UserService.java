package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.AddressDto;
import br.com.cantinhodamarmita.entitys.UpdatePasswordDto;
import br.com.cantinhodamarmita.entitys.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    User create(User user, UserRole userRole);
    void autenticateUser(User user);
    User update(User user);
    User findById(String id);
    void changeSecret(UpdatePasswordDto dto);
    boolean remove(User user, HttpServletRequest request, HttpServletResponse response);

    void addAdress(User user, AddressDto addressDto);

    boolean removeAddress(User user, int addressPosition);
}
