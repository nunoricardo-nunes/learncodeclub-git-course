package com.device.sales.dto;

import com.device.sales.model.Store;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDto {
    private Store store;
    private String brand;
    private String model;
    private String description;
    private BigDecimal price;

    public ProductDto(String brand, String model, String description, BigDecimal price) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.price = price;
    }
}
