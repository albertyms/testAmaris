package com.amaris.service;

import com.amaris.entity.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Long id);

}
