package br.com.cantinhodamarmita.daos;


import br.com.cantinhodamarmita.entitys.UpdatePasswordDto;
import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImp implements UserDao {

    private UserRepository repository;
    private MongoOperations mongoOperations;

    @Autowired
    public UserDaoImp(UserRepository repository, MongoOperations mongoOperations){
        this.repository = repository;
        this.mongoOperations = mongoOperations;
    }

    public UserDaoImp(){}

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {

        Update update = new Update()
                .set("email", user.getEmail())
                .set("name", user.getName())
                .set("cellphone", user.getCellphone())
                .set("telephone", user.getTelephone())
                .set("birthDate", user.getBirthDate());

        Query query = new Query(Criteria.where("_id").is(user.getId()));
        return mongoOperations.findAndModify(query, update, new FindAndModifyOptions().returnNew(true),User.class);
    }

    @Override
    public User updatePassword(UpdatePasswordDto updatePasswordDto) {
        return null;
    }

    @Override
    public User findById(String id) {
        return findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
