package com.bach.qlkh.service.impl;

import com.bach.qlkh.dto.CustomerDto;
import com.bach.qlkh.mapper.CustomerMapper;
import com.bach.qlkh.model.Customer;
import com.bach.qlkh.repository.CustomerRepository;
import com.bach.qlkh.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::mapToCustomerDto)
                .toList();
    }

    @Override
    public void createCustomer(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        customerRepository.save(customer);

    }

    @Override
    public CustomerDto findCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public void updateCustomer(Long customerId, CustomerDto customerDto) {

        Customer customer = customerRepository.findById(customerId).get();
        CustomerMapper.updateCustomerFromCustomerDto(customer, customerDto);
        customer.setId(customerId);
        customerRepository.save(customer);

    }

    @Override
    public void deleteCustomer(Long customerId) {

        customerRepository.deleteById(customerId);

    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

}
