package br.com.cantinhodamarmita.controllers;


import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.entitys.District;
import br.com.cantinhodamarmita.repositories.CityRepository;
import br.com.cantinhodamarmita.repositories.DistrictRepository;
import br.com.cantinhodamarmita.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @Autowired private DistrictRepository districtRepository;
    @Autowired private CityRepository cityRepository;
    @Autowired private StateRepository stateRepository;

    @RequestMapping(value = "/pop/system", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    public String populateAddress(){
        final City city = cityRepository.findOne("Indaiatuba");

        long count = districtRepository.count();

        if(count == 0) {
            List<District> districts = Arrays.asList(
                    new District("Vila Lopes", 5.00, city),
                    new District("Itaici", 7.00, city),
                    new District("Centro", 2.00, city),
                    new District("Pau Preto", 4.00, city)
            );

            districtRepository.save(districts);

            City campinas = new City("Campinas", city.getState());
            cityRepository.save(campinas);

            return "ok populado!";
        }

        return "Distritos ja existem";

    }

}
