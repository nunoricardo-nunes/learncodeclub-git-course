package com.device.sales.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "store_id", nullable = false, referencedColumnName = "id")
    private Store store;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    public Product() {
    }

    public Product(Store store, String brand, String model, String description, BigDecimal price) {
        this.store = store;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.price = price;
    }
}
