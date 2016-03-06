package br.com.cantinhodamarmita.controllers;

import br.com.cantinhodamarmita.entitys.City;
import br.com.cantinhodamarmita.entitys.State;
import br.com.cantinhodamarmita.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CityControllerImp implements CityController {

    @Autowired
    private CityService cityService;

    @Override
    @RequestMapping(value = URL_AJAX_COMBO_BY_STATE, method = RequestMethod.GET)
    public String findAllByState(@PathVariable("state") String state, Model model) {
        List<City> citys = cityService.findByStateId(state);
        model.addAttribute("citys",citys);
        return "ajax/combo-city :: options-citys";
    }
}
