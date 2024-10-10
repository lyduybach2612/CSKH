package com.bach.qlkh.service.impl;

import com.bach.qlkh.configuration.SecurityUtil;
import com.bach.qlkh.dto.ProductDto;
import com.bach.qlkh.mapper.ProductMapper;
import com.bach.qlkh.model.Manager;
import com.bach.qlkh.model.Product;
import com.bach.qlkh.repository.ManagerRepository;
import com.bach.qlkh.repository.ProductRepository;
import com.bach.qlkh.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    ManagerRepository managerRepository;
    ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapToProductDto).toList();

    }

    @Override
    public void createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
        productRepository.save(product);

    }

    @Override
    public ProductDto findProductById(Long productId) {

        Product product = productRepository.findById(productId).get();
        return ProductMapper.mapToProductDto(product);

    }

    @Override
    public void updateProduct(Long productId, ProductDto productDto) {

        Product product = productRepository.findById(productId).get();
        ProductMapper.updateProductFromProductDto(productDto, product);
        product.setId(productId);
        productRepository.save(product);

    }

    @Override
    public void deleteProduct(Long productId) {

        productRepository.deleteById(productId);

    }

}
