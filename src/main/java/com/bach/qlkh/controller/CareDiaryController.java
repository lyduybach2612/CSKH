package com.bach.qlkh.controller;


import com.bach.qlkh.configuration.SecurityUtil;
import com.bach.qlkh.dto.CareDiaryDto;
import com.bach.qlkh.model.Customer;
import com.bach.qlkh.model.Manager;
import com.bach.qlkh.service.CareDiaryService;
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
@RequestMapping("/careDiaries")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CareDiaryController {

    CareDiaryService careDiaryService;
    ManagerService managerService;
    CustomerService customerService;

    @GetMapping()
    public String careDiaryList(Model model) {

        List<CareDiaryDto> careDiaries = careDiaryService.getAllCareDiaries();
        String username = SecurityUtil.getSessionUser();

        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);

        Customer customer = customerService.findByUsername(username);
        if (customer != null) {
            model.addAttribute("customer", customer);
        }
        model.addAttribute("careDiaries", careDiaries);
        return "care-diary-list";

    }

    @GetMapping("/new")
    public String createCareDiaryForm(Model model) {

        String username = SecurityUtil.getSessionUser();

        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);
        CareDiaryDto careDiary = new CareDiaryDto();
        model.addAttribute("careDiary", careDiary);
        return "create-care-diary";

    }

    @PostMapping("/new")
    public String createCareDiary(@ModelAttribute("careDiary") @Valid CareDiaryDto careDiary,
                                  BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("careDiary", careDiary);
            return "create-care-diary";
        }

        careDiaryService.createCareDiary(careDiary);
        return "redirect:/careDiaries";

    }

    @GetMapping("/active/{careDiaryId}")
    public String activeCareDiary(@PathVariable Long careDiaryId, Model model) {

        careDiaryService.activeCareDiary(careDiaryId);
        return "redirect:/careDiaries";

    }

    @GetMapping("/edit/{careDiaryId}")
    public String editCareDiaryForm(@PathVariable Long careDiaryId, Model model) {

        String username = SecurityUtil.getSessionUser();

        Manager manager = managerService.findByUsername(username);
        boolean isManager = manager != null;
        model.addAttribute("isManager", isManager);
        CareDiaryDto careDiary = careDiaryService.findCareDiary(careDiaryId);
        model.addAttribute("careDiary", careDiary);
        return "edit-care-diary";

    }

    @PostMapping("/edit/{careDiaryId}")
    public String editCareDiary(@PathVariable("careDiaryId") Long careDiaryId,
                                @ModelAttribute("careDiary") @Valid CareDiaryDto careDiary,
                                BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("careDiary", careDiary);
            return "edit-care-diary";
        }
        careDiaryService.updateCareDiary(careDiaryId,careDiary);
        return "redirect:/careDiaries";

    }

}
