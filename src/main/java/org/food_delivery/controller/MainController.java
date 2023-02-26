package org.food_delivery.controller;

import org.food_delivery.dto.ProductDto;
import org.food_delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    private ProductDto productDto;
    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String addFoodItemGet(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addFoodItemPost(@ModelAttribute ProductDto productDto,
                                  @RequestParam("productImage") MultipartFile multipartFile) {
        productService.addProduct(productDto, multipartFile);
        return "addProduct";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        List<ProductDto> productDtos = productService.findAllProductDtos();
        model.addAttribute("productDtos", productDtos);
        return "home";
    }

    @GetMapping("/product/{productId}")
    public String viewProductGet(@PathVariable(value = "productId") String productId, Model model) {
        System.out.println("Am dat click pe produsul cu id-ul: " + productId);
        Optional<ProductDto> optionalProductDto = productService.optionalFindProductDtoById(productId);
        if(optionalProductDto.isEmpty()){
            return "error";
        }
        ProductDto productDto = optionalProductDto.get();
        model.addAttribute("productDto", productDto);
        return "viewProduct";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
