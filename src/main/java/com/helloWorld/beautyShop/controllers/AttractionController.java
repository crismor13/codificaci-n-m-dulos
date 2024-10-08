package com.helloWorld.beautyShop.controllers;

import com.helloWorld.beautyShop.services.AttractionService;
import com.helloWorld.beautyShop.services.EmployeeService;
import com.helloWorld.beautyShop.services.VisitorService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@Slf4j
public class AttractionController {


    @Autowired
    VisitorService visitorService;
    @Autowired
    AttractionService attractionService;


    @PostMapping("/attractions")
    public String createAttraction(@RequestParam Long attractionId, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        if (visitorService.isAuthenticated(session)) {

//            log.info("visitor session attribute:");
//            log.info(session.getAttribute("visitor").toString());

            VisitorModel cacheVisitorInfo = (VisitorModel) session.getAttribute("visitor");
            log.info("cacheVisitorInfo:");
            log.info(cacheVisitorInfo.toString());
            Long visitorId = cacheVisitorInfo.getId();


//            Optional<VisitorModel> visitor = visitorService.getVisitorById((Long) session.getAttribute("visitor"))

            if (cacheVisitorInfo.getTicket().getTicketBalance() <= 0) {
                redirectAttributes.addFlashAttribute("message", "Your ticket has no more balance");
                return "redirect:/attractions";
            }
            Optional<AttractionModel> attractionModel = attractionService.getAttractionById(attractionId);
            if(attractionModel.isEmpty()) {
                log.info("Attraction with specified id does not exist");
                return "404";
            }
            if (attractionModel.get().getMinHeightAllowed() > cacheVisitorInfo.getHeight()) {
                redirectAttributes.addFlashAttribute("message", "You are too short for this attraction");
                return "redirect:/attractions";
            }
            return "redirect:/buttons";

        }
        log.info("You are not logged in");
        return "404";
    }

    @GetMapping("/attractions")
    public String getAttractions(HttpSession session, Model model) {
        if (visitorService.isAuthenticated(session)) {
            List <AttractionModel> attractions = attractionService.getAllAttractions();

            model.addAttribute("attractions", attractions);
            return  "attractions";

        }
        return  "404";
    }

}