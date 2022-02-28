package com.geekbrains.spring_web.service;

import com.geekbrains.spring_web.entities.Product;
import com.geekbrains.spring_web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
       return (List<Product>) productRepository.findAll();
    }

    public void removeById(Long id) {
        productRepository.deleteById(id);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Optional<Product> getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }
}
