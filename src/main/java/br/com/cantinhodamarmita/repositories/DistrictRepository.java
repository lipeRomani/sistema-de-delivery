package br.com.cantinhodamarmita.repositories;

import br.com.cantinhodamarmita.entitys.District;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DistrictRepository extends MongoRepository<District, String> {

    @Override
    District save(District district);

    @Override
    District findOne(String s);
}
