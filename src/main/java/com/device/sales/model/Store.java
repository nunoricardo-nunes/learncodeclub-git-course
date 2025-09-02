package com.device.sales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "store")
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public Store() {
    }

    public Store(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
