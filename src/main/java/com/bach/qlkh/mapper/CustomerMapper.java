package com.bach.qlkh.mapper;

import com.bach.qlkh.dto.CustomerDto;
import com.bach.qlkh.model.Customer;


public class CustomerMapper {

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .address(customerDto.getAddress())
                .email(customerDto.getEmail())
                .gender(customerDto.getGender())
                .phoneNumber(customerDto.getPhoneNumber())
                .dateOfBirth(customerDto.getDateOfBirth())
                .password(customerDto.getPassword())
                .username(customerDto.getUsername())
                .careDiaries(customerDto.getCareDiaries())
                .build();
    }

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .gender(customer.getGender())
                .phoneNumber(customer.getPhoneNumber())
                .dateOfBirth(customer.getDateOfBirth())
                .password(customer.getPassword())
                .username(customer.getUsername())
                .careDiaries(customer.getCareDiaries())
                .build();
    }

    public static void updateCustomerFromCustomerDto(Customer customer, CustomerDto customerDto) {

        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setEmail(customerDto.getEmail());
        customer.setGender(customerDto.getGender());
        customer.setDateOfBirth(customerDto.getDateOfBirth());

    }

}
