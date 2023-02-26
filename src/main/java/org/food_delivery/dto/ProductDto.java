package org.food_delivery.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private String id;
    private String name;
    private String ingredients;
    private String weigth;
    private String price;

    @ToString.Exclude
    private String image;

}
