package org.food_delivery.service;

import org.food_delivery.dto.ProductDto;
import org.food_delivery.entities.Product;
import org.food_delivery.mapper.ProductMapper;
import org.food_delivery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDto productDto){
        Product product = productMapper.map(productDto);
        productRepository.save(product);


    }
}
