package br.com.cantinhodamarmita.repositories;


import br.com.cantinhodamarmita.entitys.State;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateRepository extends MongoRepository<State, String> {

    @Override
    State save(State state);

    @Override
    State findOne(String s);
}
