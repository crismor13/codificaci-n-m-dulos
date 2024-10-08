//package com.helloWorld.beautyShop.services.implementation;
//
//import com.helloWorld.beautyShop.repositories.TicketRepository;
//import com.helloWorld.beautyShop.services.TicketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TicketImp implements TicketService {
//
//    @Autowired
//    private TicketRepository ticketRepository;
//
//    @Override
//    public TicketModel saveTicket(TicketModel newTicket) {
//        return ticketRepository.save(newTicket);
//    }
//
//    @Override
//    public List<TicketModel> getAllTickets() {
//        return (List<TicketModel>) ticketRepository.findAll();
//    }
//}
