package com.bach.qlkh.controller;

import com.bach.qlkh.configuration.SercurityUtil;
import com.bach.qlkh.model.Manager;
import com.bach.qlkh.service.CustomerService;
import com.bach.qlkh.service.ManagerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        String username = SercurityUtil.getSessionUser();
        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);
        return "layout";
    }


}
