package com.bach.qlkh.mapper;

import com.bach.qlkh.dto.ProductDto;
import com.bach.qlkh.model.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductDto product) {

        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .imageURL(product.getImageUrl())
                .build();

    }

    public static ProductDto mapToProductDto(Product product) {

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .imageUrl(product.getImageURL())
                .build();

    }

    public static void updateProductFromProductDto(ProductDto productDto, Product product) {

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageUrl());

    }

}
