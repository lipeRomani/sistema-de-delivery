package br.com.cantinhodamarmita.daos;


import br.com.cantinhodamarmita.entitys.District;

import java.util.List;

public interface DistrictDao {
    List<District> findByCityName(String cityName);
    District findById(String id);
}
