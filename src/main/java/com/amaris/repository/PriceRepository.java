package com.amaris.repository;

import com.amaris.entity.Brand;
import com.amaris.entity.Price;
import com.amaris.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    @Query("select p from Price p where :dateApply between p.startDate and p.endDate and p.product = :product and p.brand = :brand")
    Optional<List<Price>> findByDateApplyBetweenStartDateAndEndDateAndBrandAndProduct(@Param("dateApply") Date dateApply, @Param("brand") Brand brand, @Param("product") Product product);

}
