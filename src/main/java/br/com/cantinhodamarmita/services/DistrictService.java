package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.entitys.District;

import java.util.List;

public interface DistrictService {

    District save(District district);
    List<District> getAllByCity(City city);
    void delete(District district);
    District update (District district);
    District findOne(String id);


}
