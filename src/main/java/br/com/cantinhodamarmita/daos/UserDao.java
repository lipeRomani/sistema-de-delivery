package br.com.cantinhodamarmita.daos;


import br.com.cantinhodamarmita.entitys.UpdatePasswordDto;
import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.repositories.UserRepository;

public interface UserDao {

    User save(User user);
    User update(User user);
    User updatePassword(UpdatePasswordDto updatePasswordDto, String userId);
    User findById(String id);
    User findByEmail(String email);
}
