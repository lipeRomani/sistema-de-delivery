package br.com.cantinhodamarmita.daos;

import br.com.cantinhodamarmita.entitys.District;
import br.com.cantinhodamarmita.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class DistrictDaoImp implements DistrictDao {

    private DistrictRepository districtRepository;
    private MongoOperations operations;

    @Autowired
    public DistrictDaoImp(DistrictRepository districtRepository, MongoOperations operations) {
        this.districtRepository = districtRepository;
        this.operations = operations;
    }

    @Override
    public List<District> findByCityName(String cityName) {
        Query query = query(where("city.$id").is(cityName)).with(new Sort(Sort.Direction.ASC,"name"));
        return operations.find(query,District.class);
    }

    @Override
    public District findById(String id) {
        return districtRepository.findOne(id);
    }
}
