package br.com.cantinhodamarmita.controllers;


import br.com.cantinhodamarmita.entitys.Product;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ProductsController {

    String createProductForm(Model model);
    String creatProductSubmit(Product product, BindingResult result, RedirectAttributes redirectAttributes, Model model);
    String updateProduct(Product product, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String changeAvailableDate(Product product, RedirectAttributes redirectAttributes);
    String changeStatus(Product product, RedirectAttributes redirectAttributes);
    String removeProduct(Product product, RedirectAttributes redirectAttributes);

}
