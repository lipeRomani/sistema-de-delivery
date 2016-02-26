package br.com.cantinhodamarmita.controllers;


import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.entitys.UserFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

public interface UsersController {

    String formCreateUser(Model model, Principal principal);
    String createUser(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String updateUser(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes);
    String usersList(UserFilter userFilter, Pageable pageable);
    String removeUser(User user, RedirectAttributes redirectAttributes);
    String detailUserInformation(User user, Model model);
    String loginForm(Model model, Principal principal);
    String loginSubmit();
    String dashBoard(User user,Model model);

}
