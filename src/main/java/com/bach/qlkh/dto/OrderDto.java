package com.bach.qlkh.dto;

import com.bach.qlkh.model.Customer;
import com.bach.qlkh.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    Long id;
    Customer customer;
    Product product;
    LocalDateTime createdTime;

}
