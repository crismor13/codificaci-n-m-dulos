package com.helloWorld.beautyShop.controllers;

import com.helloWorld.beautyShop.DTOs.VisitorRegisterForm;
import com.helloWorld.beautyShop.models.Product;
import com.helloWorld.beautyShop.models.Sale;
import com.helloWorld.beautyShop.models.User;
import com.helloWorld.beautyShop.services.ProductService;
import com.helloWorld.beautyShop.services.SaleService;
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

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    ProductService productService;
    @Autowired
    SaleService saleService;

    @GetMapping("/home")
    public String home(Model model) {

        List<Product> lowStockProducts = productService.getLowStockProducts(15);
        List<Sale> recentSales = saleService.getMostRecentSales();

        // Add the data to the model
        model.addAttribute("lowStockProducts", lowStockProducts);
        model.addAttribute("recentSales", recentSales);

        // Return the name of the Thymeleaf template (home.html)
        return "home";
    }

}