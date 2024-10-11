package com.bach.qlkh.service.impl;

import com.bach.qlkh.configuration.SecurityUtil;
import com.bach.qlkh.dto.OrderDto;
import com.bach.qlkh.mapper.OrderMapper;
import com.bach.qlkh.model.Customer;
import com.bach.qlkh.model.Order;
import com.bach.qlkh.model.Product;
import com.bach.qlkh.repository.CustomerRepository;
import com.bach.qlkh.repository.OrderRepository;
import com.bach.qlkh.repository.ProductRepository;
import com.bach.qlkh.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    ProductRepository productRepository;

    @Override
    public List<OrderDto> getAll() {

        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderMapper::mapToOrderDto).toList();

    }

    @Override
    public void createOrder(OrderDto orderDto, Long productId) {

        Product product = productRepository.findById(productId).get();
        String username = SecurityUtil.getSessionUser();
        Customer customer = customerRepository.findByUsername(username);
        orderDto.setCustomer(customer);
        orderDto.setProduct(product);
        orderRepository.save(OrderMapper.mapToOrder(orderDto));

    }
}
