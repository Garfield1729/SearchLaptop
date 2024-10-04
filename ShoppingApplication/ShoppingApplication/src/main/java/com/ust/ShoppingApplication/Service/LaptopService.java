package com.ust.ShoppingApplication.Service;

import com.ust.ShoppingApplication.Model.Laptop;
import com.ust.ShoppingApplication.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public List<Laptop> filterLaptopsByBudget(Double minPrice, Double maxPrice) {
        return laptopRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
