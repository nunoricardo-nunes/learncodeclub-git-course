package com.device.sales.dto;

import lombok.Data;

@Data
public class StoreDto {
    private Long storeId;
    private String name;
    private String address;
    private String phone;

    public StoreDto(Long storeId, String name, String address, String phone) {
        this.storeId = storeId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
