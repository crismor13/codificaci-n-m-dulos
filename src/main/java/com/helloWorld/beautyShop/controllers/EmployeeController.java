//package com.helloWorld.beautyShop.controllers;
//
//import com.helloWorld.beautyShop.services.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class EmployeeController {
//
//    @Autowired
//    EmployeeService employeeService;
//
//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//
//    @PostMapping("/registerEmployee")
//    public ResponseEntity<?> createEmployee(@RequestBody EmployeeModel newEmployee){
//
//        try{
//            EmployeeModel prueba = employeeService.saveEmployee(newEmployee);
//            return  new ResponseEntity(prueba,HttpStatus.CREATED);
//        }catch (Exception e){
//            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
//
//}