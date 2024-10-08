//package com.helloWorld.beautyShop.controllers;
//
//import com.helloWorld.beautyShop.DTOs.TicketDto;
//import com.helloWorld.beautyShop.DTOs.VisitorRegisterForm;
//import com.helloWorld.beautyShop.models.*;
//import com.helloWorld.beautyShop.services.StationService;
//import com.helloWorld.beautyShop.services.TicketService;
//import com.helloWorld.beautyShop.services.VisitorService;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//@Slf4j
//public class StationController {
//
//
//    @Autowired
//    VisitorService visitorService;
//    @Autowired
//    StationService stationService;
//
//    @Autowired
//    TicketService ticketService;
//
//
//    @GetMapping("/station")
//    public String showStationTickets(@RequestParam Long stationId, HttpSession session, Model model) {
//        if (visitorService.isAuthenticated(session)) {
//            StationModel station = stationService.getStationById(stationId).get();
//            List<TicketDto> ticketsList = Arrays.asList(
//                    new TicketDto(TicketType.GENERAL),
//                    new TicketDto(TicketType.DIAMOND),
//                    new TicketDto(TicketType.GOLD)
//            );
//            model.addAttribute("currentStation", station);
//            model.addAttribute("tickets", ticketsList);
//            return "station";
//
//        }
//        return  "404";
//    }
//
//
//
//}