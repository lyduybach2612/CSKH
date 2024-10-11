package com.bach.qlkh.controller;


import com.bach.qlkh.configuration.SecurityUtil;
import com.bach.qlkh.dto.OrderDto;
import java.util.List;

import com.bach.qlkh.model.Customer;
import com.bach.qlkh.model.Manager;
import com.bach.qlkh.service.CustomerService;
import com.bach.qlkh.service.ManagerService;
import com.bach.qlkh.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderController {

    OrderService orderService;
    ManagerService managerService;
    CustomerService customerService;

    @GetMapping()
    public String orderListForm(Model model) {

        String username = SecurityUtil.getSessionUser();
        Manager manager = managerService.findByUsername(username);
        boolean isManager = false;
        if (manager != null) {
            isManager = true;
        }
        model.addAttribute("isManager", isManager);
        Customer customer = customerService.findByUsername(username);
        model.addAttribute("customer", customer);
        List<OrderDto> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "order-list";

    }

    @GetMapping("/{productId}")
    public String createOrder(OrderDto orderDto,
                              @PathVariable("productId") Long productId,
                              Model model) {

        orderService.createOrder(orderDto, productId);
        return "redirect:/orders";

    }

}
