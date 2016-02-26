package br.com.cantinhodamarmita.services;

import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.entitys.District;
import br.com.cantinhodamarmita.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class DistrictServiceImp implements DistrictService {

    private DistrictRepository districtRepository;

    private MongoOperations mongoOperations;

    @Autowired
    public DistrictServiceImp(DistrictRepository districtRepository, MongoOperations mongoOperations) {
        this.districtRepository = districtRepository;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public District save(District district) {
        return null;
    }

    @Override
    public List<District> getAllByCity(City city) {
        Query query = query(where("city.$id").is(city.getName()));
        return mongoOperations.find(query,District.class);
    }

    @Override
    public void delete(District district) {

    }

    @Override
    public District update(District district) {
        return null;
    }

    @Override
    public District findOne(String id) {
        return null;
    }
}
