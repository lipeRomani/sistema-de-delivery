package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.City;

import java.util.List;

public interface CityService {

    City findOne(String id);
    List<City> findByStateId(String stateId);

}
