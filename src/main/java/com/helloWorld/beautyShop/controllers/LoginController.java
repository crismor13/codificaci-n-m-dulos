package com.helloWorld.beautyShop.controllers;

import com.helloWorld.beautyShop.DTOs.VisitorLoginForm;
import com.helloWorld.beautyShop.DTOs.VisitorRegisterForm;
import com.helloWorld.beautyShop.models.User;
import com.helloWorld.beautyShop.services.AuthService;
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
public class LoginController {


    @Autowired
    VisitorService visitorService;
    @Autowired
    AuthService authService;


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new VisitorLoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid @ModelAttribute("loginForm") VisitorLoginForm visitorForm,
                            BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "login";
        }

        if(!authService.authenticate(visitorForm.getUserName(), visitorForm.getPassword())) {
            redirectAttributes.addFlashAttribute("loginError", "Invalid username or password");
            return "redirect:/login"; // Use redirect to prevent form resubmission
        }

        try{
            session.setAttribute("isUserAuthenticated", true);
            User loggedUser = visitorService.getUserByUsername(visitorForm.getUserName()).get();
            log.info("Username: {}", visitorForm.getUserName());
            log.info("loggedUser: {}", loggedUser.toString());
            session.setAttribute("visitor", loggedUser);
            return  "redirect:/home";
        }catch (Exception e){
            log.error(e.getMessage());
            return  "redirect:/404";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();

        // Redirect to login page or home page after logout
        return "redirect:/login";
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
            return  "redirect:/404";
        }
    }


}