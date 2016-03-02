package br.com.cantinhodamarmita.controllers;

import br.com.cantinhodamarmita.entitys.*;
import br.com.cantinhodamarmita.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UsersControllerImp implements UsersController {

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value = URL_CREATE_USER, method = RequestMethod.GET)
    public String createForm(Model model, Principal principal) {

        if(principal != null)
            return "redirect:" + URL_DASHBOARD_USER;

        model.addAttribute("user",new User());
        return "users/join";
    }

    @Override
    @RequestMapping(value = URL_CREATE_USER, method = RequestMethod.POST)
    public String createSubmit(@Valid User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if(!result.hasErrors()){
            user = userService.createUser(user, new UserRoleConsumer());
            userService.autenticateUser(user);
            return "redirect:" + URL_DASHBOARD_USER;
        }

        model.addAttribute("user",user);
        return "users/join";
    }

    @Override
    @RequestMapping(value = URL_UPDATE_USER, method = RequestMethod.GET)
    public String updateForm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        return "users/update";
    }

    @Override
    @RequestMapping(value = URL_UPDATE_USER,method = RequestMethod.POST)
    public String updateSubmit(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        return "users/update";
    }

    @Override
    public String usersList(UserFilter userFilter, Pageable pageable) {
        return null;
    }

    @Override
    @RequestMapping(value = URL_REMOVE_USER, method = RequestMethod.POST)
    public String removeUser(User user, RedirectAttributes redirectAttributes) {
        return null;
    }

    @Override
    @RequestMapping(value = URL_DETAIL_USER, method = RequestMethod.GET)
    public String userDetail(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        return "users/detail";
    }

    @Override
    @RequestMapping(value = URL_LOGIN_USER, method = RequestMethod.GET)
    public String loginForm(Model model, Principal principal){
        if(principal != null) return "redirect:" + URL_DASHBOARD_USER;
        return "users/login";
    }

    @RequestMapping(value = URL_LOGIN_FAIL_USER, method = RequestMethod.GET)
    public String loginFail(Model model, Principal principal){

        if(principal != null) return "redirect:" + URL_DASHBOARD_USER;

        model.addAttribute("error","Usuário ou senha inválidos");
        return "users/login";
    }

    @Override
    @RequestMapping(value = URL_DASHBOARD_USER, method = RequestMethod.GET)
    public String dashBoard(@AuthenticationPrincipal User user, Model model) {

        return "users/dashboard";
    }
}
