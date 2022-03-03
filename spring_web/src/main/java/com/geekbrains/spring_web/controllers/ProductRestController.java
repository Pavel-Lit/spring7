package com.geekbrains.spring_web.controllers;

import com.geekbrains.spring_web.entities.Product;
import com.geekbrains.spring_web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService =productService;
    }
    @GetMapping("/product/{id}")
    public Optional<Product>  getProductById(@PathVariable(value = "id")Long id){
        return productService.getById(id);
    }

    @GetMapping("/product/all")
    public List<Product> getAllProduct(){
        List<Product> productList = productService.getAllProduct();
        return productList;
    }

    @DeleteMapping("/delete/{id}")
    public int deleteProduct(@PathVariable long id){
        productService.deleteById(id);
        return HttpStatus.OK.value();
    }
    @PostMapping("/new-product")
    public Product addProduct(@RequestBody Product newProduct){
//        newProduct.setId(0L);
        productService.saveOrUpdate(newProduct);
        return newProduct;
    }

    @PutMapping(path = "/new-product", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product){
        productService.saveOrUpdate(product);
        return product;
    }

}
