package br.com.cantinhodamarmita.repositories;

import br.com.cantinhodamarmita.entitys.City;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepository extends MongoRepository<City, String> {

    @Override
    City save(City city);

    @Override
    City findOne(String s);

    @Override
    List<City> findAll();


}
