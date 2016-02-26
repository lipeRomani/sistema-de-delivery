package br.com.cantinhodamarmita.services;

import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImp implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImp(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public City findOne(String id){
        return cityRepository.findOne(id);
    }

}
