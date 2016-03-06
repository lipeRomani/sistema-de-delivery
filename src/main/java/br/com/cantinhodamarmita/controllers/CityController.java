package br.com.cantinhodamarmita.controllers;


import br.com.cantinhodamarmita.entitys.State;
import org.springframework.ui.Model;

public interface CityController {

    String URL_AJAX_COMBO_BY_STATE = "/city/combo/{state}";

    String findAllByState(String state, Model model);
}
