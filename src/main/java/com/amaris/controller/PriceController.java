package com.amaris.controller;

import com.amaris.entity.Brand;
import com.amaris.entity.Price;
import com.amaris.entity.Product;
import com.amaris.response.PricesResponse;
import com.amaris.service.PriceService;
import com.amaris.service.impl.BrandServiceImpl;
import com.amaris.service.impl.ProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api/prices")
public class PriceController {
    private final Logger logger = LogManager.getLogger(PriceController.class);
    static final String ERROR_PROCESS = "Error: ";
    static final String ERROR_REQUEST = "Error trying to process the request: ";

    @Autowired
    BrandServiceImpl brandService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    PriceService service;

    @GetMapping
    public ResponseEntity<Object> findById(@RequestParam(value = "dateApply") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateApply,
                                           @RequestParam(value = "brandId") Long brandId, @RequestParam(value = "productId") Long productId) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateApply);

            Optional<Brand> brand = brandService.getBrandById(brandId);
            if (!brand.isPresent()) {
                return new ResponseEntity<>("This brand not exists.", HttpStatus.NOT_FOUND);
            }
            Optional<Product> product = productService.getProductById(productId);
            if (!product.isPresent()) {
                return new ResponseEntity<>("This product not exists.", HttpStatus.NOT_FOUND);
            }
            Optional<Price> price = service.findByParams(dateApply, brand.get(), product.get());

            if (price.isPresent()) {
                String message = String.format("petición a las %s del día %s del producto %s para la brand %s",
                        calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.DAY_OF_MONTH), price.get().getProduct().getId(), price.get().getBrand().getBrand());
                PricesResponse pricesResponse = new PricesResponse(message, price.get());
                return ResponseEntity.ok(pricesResponse);
            } else {
                return new ResponseEntity<>("This Price not exists", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }


}
