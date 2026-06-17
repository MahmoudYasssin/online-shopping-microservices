package com.example.product_service.service;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.ProductRequest;

import java.util.List;

public interface ProductService {

    void createProduct(ProductRequest productDto);
    List<ProductDto> getAllProducts();
}
