package com.amaris.service.impl;

import com.amaris.entity.Product;
import com.amaris.repository.ProductRepository;
import com.amaris.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }
}
