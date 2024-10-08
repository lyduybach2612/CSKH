package com.bach.qlkh.controller;

import com.bach.qlkh.dto.CustomerDto;
import com.bach.qlkh.model.Customer;
import com.bach.qlkh.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomerController {

    CustomerService customerService;

    @GetMapping()
    public String listCustomersForm(Model model) {
        List<CustomerDto> customers = customerService.getAllCustomer();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/new")
    public String newCustomerForm(Model model) {
        CustomerDto customer = new CustomerDto();
        model.addAttribute("customer", customer);
        return "create-customer";
    }

    @PostMapping("/new")
    public String createCustomer(@Valid @ModelAttribute("customer") CustomerDto customer,
                                 BindingResult bindingResult, Model model
                                 ) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "create-customer";
        }
        customerService.createCustomer(customer);
        return "redirect:/customers";

    }

    @GetMapping("/edit/{customerId}")
    public String editCustomerForm(@PathVariable("customerId") Long customerId, Model model) {
        CustomerDto customer = customerService.findCustomerById(customerId);
        model.addAttribute("customer", customer);
        return "edit-customer";
    }

    @PostMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable("customerId") Long customerId,
                               @Valid @ModelAttribute("customer") CustomerDto customer,
                               BindingResult bindingResult,
                               Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "edit-customer";
        }
        customerService.updateCustomer(customerId,customer);
        return "redirect:/customers";

    }

    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customers";
    }


}
