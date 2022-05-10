package com.amaris.service.impl;

import com.amaris.entity.Brand;
import com.amaris.repository.BrandRepository;
import com.amaris.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository repository;

    @Override
    public Optional<Brand> getBrandById(Long id) {
        return repository.findById(id);
    }
}
