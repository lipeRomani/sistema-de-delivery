package br.com.cantinhodamarmita.controllers;


import br.com.cantinhodamarmita.entitys.*;
import br.com.cantinhodamarmita.services.StateService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public interface UsersController {

    String URL_CREATE_USER = "/join";
    String URL_UPDATE_USER = "/update/me";
    String URL_CHANGE_PASSWORD = "/change/secret";
    String URL_DETAIL_USER = "/detail/me";
    String URL_LOGIN_USER = "/login";
    String URL_LOGIN_FAIL_USER = "/login-fail";
    String URL_REMOVE_USER = "/remove/me";
    String URL_DASHBOARD_USER = "/me";
    String URL_ADD_ADDRESS_USER = "/add/address";
    String URL_REMOVE_ADDRESS = "/remove/me/address";

    String createForm(Model model, Principal principal);
    String createSubmit(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String updateForm(User user,Model model);
    String updateSubmit(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String updatePassword(Model model);
    String updatePasswordSubmit(UpdatePasswordDto dto, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String usersList(UserFilter userFilter, Pageable pageable);
    String removeUser(User user, RedirectAttributes redirectAttributes, Model model, HttpServletRequest request, HttpServletResponse response);
    String userDetail(User user, Model model);
    String loginForm(Model model, Principal principal);
    String dashBoard(User user,Model model);


    String createAddressForm(Model model);
    String createAddressSubmit(User user, AddressDto addressDto, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String updateAddressForm(Model model);
    String updateAddressSubmit(User user, AddressDto addressDto, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String removeAddress(int position, User user, RedirectAttributes redirectAttributes);


}
