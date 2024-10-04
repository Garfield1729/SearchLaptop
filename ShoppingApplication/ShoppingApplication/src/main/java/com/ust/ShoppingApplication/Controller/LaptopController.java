package com.ust.ShoppingApplication.Controller;

import com.ust.ShoppingApplication.Model.Laptop;
import com.ust.ShoppingApplication.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ust")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;


    @PostMapping
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop) {
        Laptop createdLaptop = laptopService.addLaptop(laptop);
        return new ResponseEntity<>(createdLaptop, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        List<Laptop> laptops = laptopService.getAllLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }


    @GetMapping("/filter")
    public ResponseEntity<List<Laptop>> filterLaptopsByBudget(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        List<Laptop> filteredLaptops = laptopService.filterLaptopsByBudget(minPrice, maxPrice);
        return new ResponseEntity<>(filteredLaptops, HttpStatus.OK);
    }
}
