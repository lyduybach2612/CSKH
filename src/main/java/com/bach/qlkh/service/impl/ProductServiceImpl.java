package com.bach.qlkh.service.impl;

import com.bach.qlkh.repository.ProductRepository;
import com.bach.qlkh.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

}
