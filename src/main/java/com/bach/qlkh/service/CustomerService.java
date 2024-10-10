package com.bach.qlkh.service;

import com.bach.qlkh.dto.CustomerDto;
import com.bach.qlkh.model.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomer();

    void createCustomer(CustomerDto customerDto);

    CustomerDto findCustomerById(Long customerId);

    void updateCustomer(Long customerId, CustomerDto customerDto);

    void deleteCustomer(Long customerId);

    Customer findByUsername(String username);
}
