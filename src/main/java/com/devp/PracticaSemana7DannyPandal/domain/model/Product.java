package com.devp.PracticaSemana7DannyPandal.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int status;
    private Category category;
    private Provider provider;

    public Product(Long id, String name, String description, double price, int status, Category category, Provider provider) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.category = category;
        this.provider = provider;
    }
}
