package com.helloWorld.beautyShop.controllers;

import com.helloWorld.beautyShop.DTOs.VisitorRegisterForm;
import com.helloWorld.beautyShop.models.User;
import com.helloWorld.beautyShop.services.VisitorService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class HomeController {


    @Autowired
    VisitorService visitorService;


    @GetMapping({"/login", "/"})
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/forgot-password.html")
    public String forgotPassword(Model model) {
        return "forgot-password";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("visitorForm", new VisitorRegisterForm());
        return "register";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        model.addAttribute("visitorForm", new VisitorRegisterForm());

        if (visitorService.isAuthenticated(session)) {

            return "home";

        }
        return "404";
    }

    @PostMapping("/register")
    public String createEmployee(@Valid @ModelAttribute("visitorForm") VisitorRegisterForm visitorForm,
                                 BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes){


        log.info(visitorForm.toString());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "register";
        }

        User newUser = new User(
                visitorForm.getUserName(),
                visitorForm.getPassword()
        );

        try{
            visitorService.saveUser(newUser);
            session.setAttribute("isUserAuthenticated", true);
            session.setAttribute("visitor", newUser);
            return  "redirect:/home";
        }catch (Exception e){
            log.error(e.getMessage());
            return  "404";
        }
    }


}