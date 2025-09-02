package com.device.sales.service;

import com.device.sales.dto.StoreDto;
import com.device.sales.exception.CreateResourceException;
import com.device.sales.exception.ResourceNotFoundException;
import com.device.sales.model.Store;
import com.device.sales.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<StoreDto> findStores(){

        List<Store> stores = storeRepository.findAll();
        if(stores.isEmpty()){
            throw new ResourceNotFoundException();
        }

        return mapStoreDto(stores);
    }

    public void addStore(StoreDto storeDto) {
        try {
            Store store = new Store(storeDto.getName(),storeDto.getAddress(),storeDto.getPhone());
            storeRepository.save(store);
        } catch(Exception e){
            throw new CreateResourceException();
        }
    }

    private List<StoreDto> mapStoreDto(List<Store> persistedStores){
        List<StoreDto> stores = new ArrayList<>();
        persistedStores.forEach(item->{
            StoreDto storeDto = new StoreDto(item.getId(),item.getName(),item.getAddress(),item.getPhone());
            stores.add(storeDto);
        });
        return stores;
    }

}
