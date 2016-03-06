package br.com.cantinhodamarmita.daos;


import br.com.cantinhodamarmita.entitys.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao {

    City findById(String id);
    List<City> findByStateId(String stateId);
}
