package br.com.cantinhodamarmita.controllers;


import org.springframework.ui.Model;

public interface DistrictController {

    String URL_AJAX_COMBO_BY_CITY = "/district/combo/{city}";

    String findAllByCity(String city, Model model);
}
