package br.com.cantinhodamarmita.controllers;


import br.com.cantinhodamarmita.entitys.UpdatePasswordDto;
import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.entitys.UserFilter;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

public interface UsersController {

    String URL_CREATE_USER = "/join";
    String URL_UPDATE_USER = "/update/me";
    String URL_CHANGE_PASSWORD = "/change/secret";
    String URL_DETAIL_USER = "/detail/me";
    String URL_LOGIN_USER = "/login";
    String URL_LOGIN_FAIL_USER = "/login-fail";
    String URL_REMOVE_USER = "/delete/me";
    String URL_DASHBOARD_USER = "/me";

    String createForm(Model model, Principal principal);
    String createSubmit(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String updateForm(User user,Model model);
    String updateSubmit(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String updatePassword(Model model);
    String updatePasswordSubmit(UpdatePasswordDto dto, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String usersList(UserFilter userFilter, Pageable pageable);
    String removeUser(User user, RedirectAttributes redirectAttributes);
    String userDetail(User user, Model model);
    String loginForm(Model model, Principal principal);
    String dashBoard(User user,Model model);

}
