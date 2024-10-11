package com.bach.qlkh.mapper;

import com.bach.qlkh.dto.OrderDto;
import com.bach.qlkh.model.Order;

public class OrderMapper {

    public static Order mapToOrder(OrderDto order) {

        return Order.builder()
                .id(order.getId())
                .product(order.getProduct())
                .customer(order.getCustomer())
                .creationDate(order.getCreatedTime())
                .build();

    }

    public static OrderDto mapToOrderDto(Order order) {

        return OrderDto.builder()
                .id(order.getId())
                .product(order.getProduct())
                .customer(order.getCustomer())
                .createdTime(order.getCreationDate())
                .build();

    }

}
