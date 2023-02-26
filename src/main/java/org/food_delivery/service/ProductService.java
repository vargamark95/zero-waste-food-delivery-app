package org.food_delivery.service;

import org.food_delivery.dto.ProductDto;
import org.food_delivery.entities.Product;
import org.food_delivery.mapper.ProductMapper;
import org.food_delivery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDto productDto, MultipartFile productImage){
        Product product = productMapper.map(productDto, productImage);
        productRepository.save(product);


    }

    public List<ProductDto> findAllProductDtos() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products){
            ProductDto productDto = productMapper.map(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public Optional<ProductDto> optionalFindProductDtoById(String productId) {
        try{
            Optional<Product> optionalProduct = productRepository.findById(Integer.valueOf(productId));
            if(optionalProduct.isEmpty()){
                return Optional.empty();
            }
            Product product = optionalProduct.get();
            ProductDto productDto = productMapper.map(product);
            return Optional.of(productDto);
        }catch (NumberFormatException e){
            return Optional.empty();
        }



    }
}
