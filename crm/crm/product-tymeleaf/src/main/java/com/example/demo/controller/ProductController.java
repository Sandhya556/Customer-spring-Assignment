package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String getAllProducts(Model model) {

        List<Product> list = productService.getAllProducts();
        model.addAttribute("PRODUCTS", list);
        return "product-list";
    }

    @GetMapping("/showFormForProduct")
    public String addProduct(Model model) {

        Product theProduct = new Product();
        model.addAttribute("PRODUCT", theProduct);
        return "product-form";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id")int id, Model model) {

        Product theProduct = productService.getProduct(id);
        model.addAttribute("PRODUCT", theProduct);

        return "product-form";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id")int id, Model model) {

        Product product = productService.getProduct(id);
        model.addAttribute("PRODUCT", product);

        return "details-form";
    }

    @PostMapping("/back")
    public String back() {

        return "redirect:/products/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id) {

        productService.deleteProduct(id);
        return "redirect:/products/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("PRODUCT")Product product) {

        Product p = productService.createProduct(product);
        System.out.println(p);
        return "redirect:/products/list";
    }
}
