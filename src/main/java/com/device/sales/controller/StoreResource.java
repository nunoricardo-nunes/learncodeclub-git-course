package com.device.sales.controller;

import com.device.sales.dto.StoreDto;
import com.device.sales.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreResource {

    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<List<StoreDto>> findStores(){
        return new ResponseEntity<List<StoreDto>>(storeService.findStores(), HttpStatus.OK);
    }

    @PostMapping
    public void createStore(@RequestBody StoreDto store){
        storeService.addStore(store);
    }

}
