package br.com.cantinhodamarmita.services;

import br.com.cantinhodamarmita.daos.DistrictDao;
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

    DistrictDao dao;

    @Autowired
    public DistrictServiceImp(DistrictDao dao) {
        this.dao = dao;
    }

    @Override
    public District save(District district) {
        return null;
    }

    @Override
    public List<District> getAllByCityName(String city) {
        return dao.findByCityName(city);
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
