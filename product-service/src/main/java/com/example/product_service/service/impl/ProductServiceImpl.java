package com.example.product_service.service.impl;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.ProductRequest;
import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public void createProduct(ProductRequest productDto) {
        Product product= ProductMapper.mapToProduct(productDto);
        System.out.println("service"+ product);

        productRepository.save(product);
        log.info("Product {} is created successfully",product.getId());

    }

    public List<ProductDto>getAllProducts()
    {
        List<Product> allProdcuts=productRepository.findAll();
        return allProdcuts.stream().map(product -> ProductMapper.maptoproductDto(product))
                .collect(Collectors.toList());
    }
}
