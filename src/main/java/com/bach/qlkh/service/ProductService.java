package com.bach.qlkh.service;

import com.bach.qlkh.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    void createProduct(ProductDto productDto);

    ProductDto findProductById(Long productId);

    void updateProduct(Long productId, ProductDto product);

    void deleteProduct(Long productId);
}
