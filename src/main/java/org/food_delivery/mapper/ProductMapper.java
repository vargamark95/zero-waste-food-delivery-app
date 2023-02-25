package org.food_delivery.mapper;

import org.food_delivery.dto.ProductDto;
import org.food_delivery.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product map(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setIngredients(productDto.getIngredients());
        product.setWeight(Integer.valueOf(productDto.getWeigth()));
        product.setPrice(Integer.valueOf(productDto.getPrice()));

        return product;
    }


}
