package com.amaris.service;

import com.amaris.entity.Brand;

import java.util.Optional;

public interface BrandService {

    Optional<Brand> getBrandById(Long id);

}
