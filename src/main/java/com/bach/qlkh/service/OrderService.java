package com.bach.qlkh.service;


import com.bach.qlkh.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAll();

    void createOrder(OrderDto orderDto, Long productId);
}
