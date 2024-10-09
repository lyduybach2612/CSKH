package com.bach.qlkh.controller;

import com.bach.qlkh.dto.ProductDto;
import com.bach.qlkh.service.ProductService;
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
@RequestMapping("/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping()
    public String listProductsForm(Model model) {

        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";

    }

    @GetMapping("/new")
    public String createProductForm(Model model) {

        ProductDto product = new ProductDto();
        model.addAttribute("product", product);
        return "create-product";

    }

    @PostMapping("/new")
    public String createProduct(@ModelAttribute("product") @Valid ProductDto product,
                                BindingResult bindingResult,
                                Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "create-product";
        }

        productService.createProduct(product);
        return "redirect:/products";

    }

    @GetMapping("/edit/{productId}")
    public String editProductForm(@PathVariable Long productId, Model model) {

        ProductDto product = productService.findProductById(productId);
        model.addAttribute("product", product);
        return "edit-product";

    }

    @PostMapping("/edit/{productId}")
    public String editProduct(@PathVariable Long productId,
                              @ModelAttribute("product") ProductDto product,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "edit-product";
        }
        productService.updateProduct(productId, product);
        return "redirect:/products";

    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Long productId) {

        productService.deleteProduct(productId);
        return "redirect:/products";

    }

}
