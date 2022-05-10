package com.amaris.service.impl;

import com.amaris.entity.Brand;
import com.amaris.entity.Price;
import com.amaris.entity.Product;
import com.amaris.repository.PriceRepository;
import com.amaris.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository repository;

    @Override
    public Optional<Price> findByParams(Date dateApply, Brand brand, Product product) {
        Optional<List<Price>> prices = repository.findByDateApplyBetweenStartDateAndEndDateAndBrandAndProduct(dateApply, brand, product);
        Optional<Price> priceOptional;
        if (prices.isPresent()) {
            if ((long) prices.get().size() > 1) {
                Price price = Collections.max(prices.get(), Comparator.comparing(Price::getPriority));
                priceOptional = Optional.ofNullable(price);
            } else if(prices.get().size() == 1) {
                priceOptional = Optional.ofNullable(prices.get().get(0));
            } else {
                return Optional.empty();
            }
            return priceOptional;
        } else {
            return Optional.empty();
        }
    }

}
