package org.food_delivery.controller;

import org.food_delivery.dto.ProductDto;
import org.food_delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private ProductDto productDto;
    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String addFoodItemGet(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addFoodItemPost(@ModelAttribute ProductDto productDto){
        productService.addProduct(productDto);
        return "addProduct";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}
