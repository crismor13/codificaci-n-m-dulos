package com.helloWorld.beautyShop.controllers;

import com.helloWorld.beautyShop.DTOs.VisitorLoginForm;
import com.helloWorld.beautyShop.DTOs.VisitorRegisterForm;
import com.helloWorld.beautyShop.models.Product;
import com.helloWorld.beautyShop.DTOs.ProductInventoryForm;
import com.helloWorld.beautyShop.models.User;
import com.helloWorld.beautyShop.services.ProductService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class InventoryController {

    @Autowired
    ProductService productService;


    @GetMapping("/inventory")
    public String register(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("productForm", new ProductInventoryForm());
        return "inventory";
    }

    @PostMapping("/inventory")
    public String addOrUpdateProduct(@Valid @ModelAttribute("productForm") ProductInventoryForm productInventoryForm,
                            BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "inventory";
        }

        if ("editForm".equals(productInventoryForm.getFormType())) {
            Product updatedProduct = new Product(
                    productInventoryForm.getName(),
                    productInventoryForm.getDescription(),
                    productInventoryForm.getPrice(),
                    productInventoryForm.getQuantity()
            );
            productService.updateProduct(updatedProduct, productInventoryForm.getId());
            return  "redirect:/inventory";

        }

        Product newProduct = new Product(
                productInventoryForm.getName(),
                productInventoryForm.getDescription(),
                productInventoryForm.getPrice(),
                productInventoryForm.getQuantity()
        );

        productService.saveProduct(newProduct);

        return  "redirect:/inventory";
    }

    @PostMapping("/inventory/delete")
    public String deleteProduct(@RequestParam("delete") Long productId) {
        productService.deleteProduct(productId); // Delete product by id
        return "redirect:/inventory";
    }


}