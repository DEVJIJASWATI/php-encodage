package org.app.controller;

import org.app.model.User;
import org.app.service.SecurityService;
import org.app.service.UserService;
import org.app.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/registration" , method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm",new User());

        return "registration";
    }

    @RequestMapping(value = "/registration" , method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm , BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()){
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getMatricule(), userForm.getPasswordConfirm());

        return "redirect:/home";

    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(Model model, String error , String logout){
        if (error != null){
            model.addAttribute("error", "Matricule & Mot de passe non valide");
        }
        if (logout != null){
            model.addAttribute("message","Deconnexion success");
        }
        return"login";
    }

    @RequestMapping(value = {"/", "/home"} , method = RequestMethod.GET)
    public String home(Model model){
        return "home";
    }
}
