package com.crud.Inventory.model;

import lombok.Data;

@Data
public class ProductDTO {

    private Long productId;
    private String name;
    private double price;
    private Integer stockCount;

    // Other attributes if needed

}
