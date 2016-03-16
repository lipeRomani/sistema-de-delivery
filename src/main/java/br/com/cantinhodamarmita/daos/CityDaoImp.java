package br.com.cantinhodamarmita.daos;

import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImp implements CityDao {

    private CityRepository repository;
    private MongoOperations operations;

    @Autowired
    public CityDaoImp(CityRepository repository, MongoOperations operations) {
        this.repository = repository;
        this.operations = operations;
    }

    @Override
    public City findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<City> findByStateId(String stateId) {
        Query query = new Query(Criteria.where("state.$id").is(stateId)).with(new Sort(Sort.Direction.ASC,"name"));
        return operations.find(query,City.class);
    }


}
