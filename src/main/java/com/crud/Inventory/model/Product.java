package com.crud.Inventory.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "product")
@Data
public class Product {
    @DynamoDBHashKey(attributeName = "productId")
    private Long productId;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private double price;

    @DynamoDBAttribute
    private Long stockCount;

    // Other attributes, getters, setters
}