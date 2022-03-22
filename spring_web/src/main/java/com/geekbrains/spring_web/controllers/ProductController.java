package com.geekbrains.spring_web.controllers;

import com.geekbrains.spring_web.entities.Product;
import com.geekbrains.spring_web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@Transactional
public class ProductController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homeController(){
        return "home";
    }
    @GetMapping("/all")
    public String allProduct(Model model){
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "all-product";
    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable(value = "id") Long id){
        productService.removeById(id);
        return "redirect:/all";
    }

    @GetMapping("/info/{id}")
    public String infoById(@PathVariable(value = "id") Long id, Model model){
        Optional<Product> product = productService.getById(id);
       model.addAttribute("product", product);
       return "product-info";
    }
    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model){
        Product product = new Product();
        product.setName("Some product");
        model.addAttribute("product", product);
        return "add-product-form";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String showAddForm(Product product){
        productService.addProduct(product);
        return "redirect:/all";
    }
}
