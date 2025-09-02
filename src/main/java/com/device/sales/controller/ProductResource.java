package com.device.sales.controller;

import com.device.sales.dto.ProductDto;
import com.device.sales.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<ProductDto>> productsByStore(@PathVariable long storeId){
        return new ResponseEntity<List<ProductDto>>(productService.productsByStore(storeId), HttpStatus.OK);
    }

}
