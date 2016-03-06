package br.com.cantinhodamarmita.daos;


import br.com.cantinhodamarmita.entitys.State;
import br.com.cantinhodamarmita.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateDaoImp implements StateDao {

    private StateRepository repository;
    private MongoOperations operations;

    @Autowired
    public StateDaoImp(StateRepository repository, MongoOperations operations) {
        this.repository = repository;
        this.operations = operations;
    }

    public StateDaoImp(){}

    @Override
    public List<State> findAll() {
        return repository.findAll();
    }
}
