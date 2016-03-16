package br.com.cantinhodamarmita.controllers;

import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.entitys.District;
import br.com.cantinhodamarmita.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DistrictControllerImp implements DistrictController {

    @Autowired
    private DistrictService districtService;

    @Override
    @RequestMapping(value = URL_AJAX_COMBO_BY_CITY, method = RequestMethod.GET)
    public String findAllByCity(@PathVariable("city") String cityName, Model model) {
        final List<District> districts = districtService.getAllByCityName(cityName);
        model.addAttribute("districts",districts);
        return "ajax/combo-district :: options-districts";
    }
}
