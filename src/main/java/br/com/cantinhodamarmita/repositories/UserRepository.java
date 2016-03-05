package br.com.cantinhodamarmita.repositories;


import br.com.cantinhodamarmita.entitys.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    User save(User user);
    User findByEmail(String email);
    User findById(String id);
    User insert(User user);
    long deleteById(String id);
}
