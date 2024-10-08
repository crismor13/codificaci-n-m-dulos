//package com.helloWorld.beautyShop.services.implementation;
//
//import com.helloWorld.beautyShop.repositories.EmployeeRepository;
//import com.helloWorld.beautyShop.services.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployeeImp implements EmployeeService {
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Override
//    public EmployeeModel saveEmployee(EmployeeModel newEmployee) {
//        return employeeRepository.save(newEmployee);
//    }
//
//    @Override
//    public boolean isVisitorHeightAllowed(Float visitorHeight, Float minHeightAllowed) {
//        if (visitorHeight < minHeightAllowed) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean hasVisitorTicketBalance(Integer ticketBalance) {
//        return (ticketBalance > 0);
//    }
//}
