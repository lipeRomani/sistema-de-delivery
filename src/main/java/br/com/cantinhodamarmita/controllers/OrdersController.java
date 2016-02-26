package br.com.cantinhodamarmita.controllers;


import br.com.cantinhodamarmita.entitys.Order;
import br.com.cantinhodamarmita.entitys.OrderFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface OrdersController {

    String createOrder(Order order, BindingResult result,Model model, RedirectAttributes redirectAttributes);
    String updateOrder(Order order,BindingResult result,Model model,RedirectAttributes redirectAttributes);
    String changeOderStatus(Order order,RedirectAttributes redirectAttributes);
    String ordersList(OrderFilter orderFilter,Pageable pageable, Model model);
    String removeOrder(Order order, RedirectAttributes redirectAttributes);
    String detailOrderInformation(Order order, Model model);

}
