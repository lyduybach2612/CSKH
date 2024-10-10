package com.bach.qlkh.controller;

import com.bach.qlkh.configuration.SecurityUtil;
import com.bach.qlkh.dto.CustomerDto;
import com.bach.qlkh.model.Customer;
import com.bach.qlkh.model.Manager;
import com.bach.qlkh.service.CustomerService;
import com.bach.qlkh.service.ManagerService;
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
    ManagerService managerService;


    @GetMapping()
    public String listCustomersForm(Model model) {

        String username = SecurityUtil.getSessionUser();
        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);
        List<CustomerDto> customers = customerService.getAllCustomer();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/new")
    public String newCustomerForm(Model model) {

        String username = SecurityUtil.getSessionUser();

        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);
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
        Customer existingCustomer = customerService.findByUsername(customer.getUsername());
        if (existingCustomer != null) {
            model.addAttribute("customer", customer);
            return "redirect:/customers/new?fail" ;
        }
        customerService.createCustomer(customer);
        return "redirect:/customers";

    }

    @GetMapping("/edit/{customerId}")
    public String editCustomerForm(@PathVariable("customerId") Long customerId, Model model) {

        String username = SecurityUtil.getSessionUser();

        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);
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
