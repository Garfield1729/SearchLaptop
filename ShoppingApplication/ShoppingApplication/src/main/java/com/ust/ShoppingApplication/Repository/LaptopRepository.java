package com.ust.ShoppingApplication.Repository;

import com.ust.ShoppingApplication.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    List<Laptop> findByPriceBetween(Double minPrice, Double maxPrice);
}