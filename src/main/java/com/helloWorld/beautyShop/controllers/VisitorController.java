package com.helloWorld.beautyShop.controllers;

import com.helloWorld.beautyShop.DTOs.VisitorRegisterForm;
import com.helloWorld.beautyShop.services.StationService;
import com.helloWorld.beautyShop.services.VisitorService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class VisitorController {


    @Autowired
    VisitorService visitorService;
    @Autowired
    StationService stationService;



    @GetMapping({"/login", "/"})
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/forgot-password.html")
    public String forgotPassword(Model model) {
//        model.addAttribute("name", name);
        return "forgot-password";
    }

    @GetMapping("/register")
    public String register(Model model) {
//        model.addAttribute("name", name);
        model.addAttribute("visitorForm", new VisitorRegisterForm());
        return "register";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
//        model.addAttribute("name", name);
        model.addAttribute("visitorForm", new VisitorRegisterForm());

        if (visitorService.isAuthenticated(session)) {

            log.info("User is authenticated!");
            List<StationModel> stationList = stationService.getAllStations();
            log.info(stationList.toString());
            session.setAttribute("stations", stationList);

            return "home";

        }
        return "404";
    }

    @PostMapping("/register")
    public String createEmployee(@Valid @ModelAttribute("visitorForm") VisitorRegisterForm visitorForm,
                                 BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes){

        if (visitorForm.getVisitorAge() !=null && visitorForm.getVisitorAge()< 18) {
            if (visitorForm.getContactName() == "") {
                bindingResult.rejectValue("contactName", "error.visitorForm", "Minor visitor should have a contact name");
            }
            if (visitorForm.getContactAge() == 0) {
                bindingResult.rejectValue("contactAge", "error.visitorForm", "Minor visitor should have a contact age");
            }
            if (visitorForm.getContactTelephone() == 0) {
                bindingResult.rejectValue("contactTelephone", "error.visitorForm", "Minor visitor should have a contact telephone");
            }
        }



        log.info(visitorForm.toString());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "register";
        }

        FamilyContactModel newContact = new FamilyContactModel(
                visitorForm.getContactName(),
                visitorForm.getContactTelephone(),
                visitorForm.getContactAge()
        );

        VisitorModel newVisitor = new VisitorModel(
                visitorForm.getVisitorName(),
                visitorForm.getVisitorIdNumber(),
                visitorForm.getVisitorAge(),
                visitorForm.getVisitorTelephone(),
                visitorForm.getVisitorEmail(),
                visitorForm.getVisitorHeight(),
                newContact,
                visitorForm.getVisitorPassword(),
                visitorForm.getEmailMessages()
        );

        try{
            VisitorModel prueba = visitorService.saveVisitor(newVisitor);
            List<StationModel> stationList = stationService.getAllStations();
            session.setAttribute("isUserAuthenticated", true);
            session.setAttribute("stations", stationList);
            session.setAttribute("visitor", newVisitor);
            return  "redirect:/home";
        }catch (Exception e){
            log.error(e.getMessage());
//            update this
            return  "404";
        }
    }

    @GetMapping("/allVisitors")
    public String showAllVisitors(Model model) {
//        model.addAttribute("name", name);

        Long myId = Long.valueOf(1);

        log.warn("Visitors:");
        log.warn(visitorService.getVisitorById(myId).toString());

        return "test";
    }


}