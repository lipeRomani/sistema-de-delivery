package br.com.cantinhodamarmita.services;

import br.com.cantinhodamarmita.daos.CityDao;
import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService {

    private CityDao dao;

    @Autowired
    public CityServiceImp(CityDao dao){
        this.dao = dao;
    }

    public City findOne(String id){
        return dao.findById(id);
    }

    @Override
    public List<City> findByStateId(String stateId) {
        return dao.findByStateId(stateId);
    }

}
