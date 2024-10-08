//package com.helloWorld.beautyShop.controllers;
//
//import com.helloWorld.beautyShop.models.*;
//import com.helloWorld.beautyShop.services.TicketService;
//import com.helloWorld.beautyShop.services.VisitorService;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Optional;
//
//@Controller
//@Slf4j
//public class TicketController {
//
//
//    @Autowired
//    VisitorService visitorService;
//    @Autowired
//    TicketService ticketService;
//
////    @GetMapping("/greeting")
////    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
////        model.addAttribute("name", name);
////        return "greeting";
////    }
//
////    @GetMapping({"/login", "/"})
////    public String login(Model model) {
//////        model.addAttribute("name", name);
////        return "login";
////    }
////
////    @GetMapping("/forgot-password.html")
////    public String forgotPassword(Model model) {
//////        model.addAttribute("name", name);
////        return "forgot-password";
////    }
////
////    @GetMapping("/register")
////    public String register(Model model) {
//////        model.addAttribute("name", name);
////        model.addAttribute("visitorForm", new VisitorRegisterForm());
////        return "register";
////    }
////
////    @GetMapping("/home")
////    public String home(Model model, HttpSession session) {
//////        model.addAttribute("name", name);
////        model.addAttribute("visitorForm", new VisitorRegisterForm());
////
////        if (visitorService.isAuthenticated(session)) {
////
////            log.info("User is authenticated!");
////            List<StationModel> stationList = stationService.getAllStations();
////            log.info(stationList.toString());
////            session.setAttribute("stations", stationList);
////
////            return "home";
////
////        }
////        return "404";
////    }
//
//    @PostMapping("/buyTicket")
//    public String createTicket(@RequestParam TicketType ticketType, HttpSession session) {
//
//        if (visitorService.isAuthenticated(session)) {
//
//            log.info("I'm buying a ticket");
//
////
//            try {
//
//                VisitorModel visitorInfoFromSession = (VisitorModel) session.getAttribute("visitor");
////                log.info("visitor casted from session:");
////                log.info(visitorInfoFromSession.toString());
//                Optional<VisitorModel> visitorFromDb = visitorService.getVisitorById(visitorInfoFromSession.getId());
//
//                if(visitorFromDb.isPresent()) {
//                    TicketModel newTicket = new TicketModel(visitorFromDb.get(), ticketType);
//                    ticketService.saveTicket(newTicket);
//                    visitorFromDb.get().setTicket(newTicket);
//                    visitorService.saveVisitor(visitorFromDb.get());
//                    session.setAttribute("visitor", visitorFromDb.get());
//                } else {
//                    log.info("Visitor with the specified id could not be found in the db");
//                }
//
////              DB Visitor now have a ticket associated with him/her
//
//
//            } catch (Exception e) {
//                log.error(e.getMessage());
//                log.error(e.getStackTrace().toString());
//            }
//
//
//            return  "redirect:/attractions";
//
//        }
//        return "404";
//    }
//
//}