package com.geekbrains.spring_web.repository;

import com.geekbrains.spring_web.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
