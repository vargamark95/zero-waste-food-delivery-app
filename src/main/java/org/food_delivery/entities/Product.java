package org.food_delivery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String ingredients;
    private Integer weight;
    private Integer price;

}
