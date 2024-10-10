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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthController {

    ManagerService managerService;
    CustomerService customerService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping
    public String layout(Model model) {
        String username = SecurityUtil.getSessionUser();
        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);
        return "layout";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        CustomerDto customer = new CustomerDto();
        model.addAttribute("customer", customer);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("customer") @Valid CustomerDto customer,
                           BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "register";
        }

        Customer existingCustomer = customerService.findByUsername(customer.getUsername());
        if (existingCustomer != null) {
            model.addAttribute("customer", customer);
            return "redirect:/customers/new?fail" ;
        }

        customerService.createCustomer(customer);
        return "redirect:/login?success";

    }

}
