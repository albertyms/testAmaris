package com.amaris.service;

import com.amaris.entity.Brand;
import com.amaris.entity.Price;
import com.amaris.entity.Product;

import java.util.Date;
import java.util.Optional;

public interface PriceService {

    Optional<Price> findByParams(Date dateApply, Brand brand, Product product);

}
