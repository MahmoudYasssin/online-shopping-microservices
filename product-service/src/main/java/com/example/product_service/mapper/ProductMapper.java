package com.example.product_service.mapper;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.ProductRequest;
import com.example.product_service.model.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductRequest productDto)
    {
        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }
    public static ProductRequest mapToProductRequest(Product product)
    {
        ProductRequest productDto=new ProductRequest();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public static ProductDto maptoproductDto(Product product)
    {
        ProductDto productDto=new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return productDto;
    }



}
