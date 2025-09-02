package com.device.sales.service;

import com.device.sales.dto.ProductDto;
import com.device.sales.exception.CreateResourceException;
import com.device.sales.exception.ResourceNotFoundException;
import com.device.sales.model.Product;
import com.device.sales.repository.ProductRepository;
import com.device.sales.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public List<ProductDto> productsByStore(long storeId){
        List<Product> productsByStore = productRepository.findByStoreId(storeId);
        if(productsByStore.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return mapProductDto(productsByStore);
    }

    public void addProduct(ProductDto product) {
        storeRepository.findById(product.getStore().getId()).ifPresentOrElse((value)->{
                productRepository.save(new Product(product.getStore(),product.getBrand(), product.getModel(), product.getDescription(), product.getPrice()));
            }, ()->{
                throw new CreateResourceException();
        });
    }

    private List<ProductDto> mapProductDto(List<Product> persistedProducts){
        List<ProductDto> products = new ArrayList<>();
        persistedProducts.forEach(item->{
            ProductDto productDto = new ProductDto(item.getBrand(),item.getModel(),item.getDescription(),item.getPrice());
            products.add(productDto);
        });
        return products;
    }

}
