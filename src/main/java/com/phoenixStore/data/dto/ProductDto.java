package com.phoenixStore.data.dto;


import lombok.Data;

@Data
public class ProductDto {

    private String name;

    private String description;

    private double price;

    private int quantity;

    private String imageUrl;
}
