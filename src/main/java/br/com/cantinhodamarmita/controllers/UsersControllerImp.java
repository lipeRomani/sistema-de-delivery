package br.com.cantinhodamarmita.controllers;

import br.com.cantinhodamarmita.entitys.*;
import br.com.cantinhodamarmita.services.*;
import br.com.cantinhodamarmita.validators.ValidateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UsersControllerImp implements UsersController {

    @Autowired
    private UserService userService;
    @Autowired
    private StateService stateService;

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
    public String createSubmit(@Validated({ValidateGroup.onCreate.class}) User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if(!result.hasErrors()){
            user = userService.create(user, new UserRoleConsumer());
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
    public String updateSubmit(@Validated(value = {ValidateGroup.onUpdate.class}) User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()){
            model.addAttribute("user",user);
            return "users/update";
        }

        userService.update(user);
        redirectAttributes.addFlashAttribute("success","Seus dados foram atualizados");
        return "redirect:/detail/me";
    }

    @Override
    @RequestMapping(value = URL_CHANGE_PASSWORD, method = RequestMethod.GET)
    public String updatePassword(Model model) {
        model.addAttribute("updatePasswordDto",new UpdatePasswordDto());
        return "users/update-secret";
    }

    @Override
    @RequestMapping(value = URL_CHANGE_PASSWORD, method = RequestMethod.POST)
    public String updatePasswordSubmit(@Valid UpdatePasswordDto dto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()){
            model.addAttribute("updatePasswordDto",dto);
            return "users/update-secret";
        }

        userService.changeSecret(dto);
        redirectAttributes.addFlashAttribute("success","Senha atualizada");
        return "redirect:/detail/me";
    }

    @Override
    public String usersList(UserFilter userFilter, Pageable pageable) {
        return null;
    }

    @Override
    @RequestMapping(value = URL_REMOVE_USER, method = RequestMethod.GET)
    public String removeUser(@AuthenticationPrincipal User user, RedirectAttributes redirectAttributes, Model model, HttpServletRequest request, HttpServletResponse response) {

        if(user == null) return "redirect:/";

        String username = user.getName();
        if(userService.remove(user,request, response)) {
            model.addAttribute("username",username);
            return "users/remove-land";
        }

        redirectAttributes.addFlashAttribute("error","Falha ao remover seu usuário, tente mais tarde");
        return "redirect:" + URL_DETAIL_USER;
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

    @Override
    @RequestMapping(value = URL_ADD_ADDRESS_USER, method = RequestMethod.GET)
    public String createAddressForm(Model model) {
        model.addAttribute("address",new Address())
                .addAttribute("states",stateService.findAll());
        return "users/add-address";
    }

    @Override
    @RequestMapping(value = URL_ADD_ADDRESS_USER, method = RequestMethod.POST)
    public String createAddressSubmit(@AuthenticationPrincipal User user,
                                      @Valid Address address,
                                      BindingResult result,
                                      Model model,
                                      RedirectAttributes redirectAttributes) {

        model.addAttribute("address",address)
                .addAttribute("states",stateService.findAll());

        return "users/add-address";
    }

    @Override
    public String updateAddressForm(Model model) {
        return null;
    }

    @Override
    public String updateAddressSubmit(User user, Address address, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        return null;
    }
}
