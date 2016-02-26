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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class UsersControllerImp implements UsersController {

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String formCreateUser(Model model, Principal principal) {

        if(principal != null)
            return "redirect:/me";

        model.addAttribute("user",new User());
        return "users/join";
    }

    @Override
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if(!result.hasErrors()){
            userService.createUser(user,new UserRoleConsumer());
            return "redirect:/join";
        }
        model.addAttribute("user",user);
        return "users/join";
    }

    @Override
    public String updateUser(User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        return null;
    }

    @Override
    public String usersList(UserFilter userFilter, Pageable pageable) {
        return null;
    }

    @Override
    public String removeUser(User user, RedirectAttributes redirectAttributes) {
        return null;
    }

    @Override
    public String detailUserInformation(User user, Model model) {
        return null;
    }

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model, Principal principal){
        if(principal != null) return "redirect:/me";
        return "users/login";
    }

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit() {
        return "redirect:/me";
    }

    @Override
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public String dashBoard(@AuthenticationPrincipal User user, Model model) {

        return "users/dashboard";
    }
}
