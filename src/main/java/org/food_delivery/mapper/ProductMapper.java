package org.food_delivery.mapper;

import org.apache.tomcat.util.codec.binary.Base64;
import org.food_delivery.dto.ProductDto;
import org.food_delivery.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Component
public class ProductMapper {

    public Product map(ProductDto productDto, MultipartFile productImage) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setIngredients(productDto.getIngredients());
        product.setWeight(Integer.valueOf(productDto.getWeigth()));
        product.setPrice(Integer.valueOf(productDto.getPrice()));
        product.setImage(convertToByte(productImage));

        return product;
    }


    public ProductDto map(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setIngredients(product.getIngredients());
        productDto.setWeigth(String.valueOf(product.getWeight()));
        productDto.setPrice(String.valueOf(product.getPrice()));
        productDto.setImage(Base64.encodeBase64String(product.getImage()));
        productDto.setId(String.valueOf(product.getId()));

        return productDto;
    }

    private byte[] convertToByte(MultipartFile productImage){
        try {
            return productImage.getBytes();
        } catch (IOException e) {
            return new byte[0];
        }

    }
}
