package com.siddardha.foodtracker.Controller;


import com.siddardha.foodtracker.Entity.FoodItem;
import com.siddardha.foodtracker.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {
    @Autowired
    private FoodItemService service;

    @PostMapping
    public ResponseEntity<FoodItem> addItem(@RequestBody FoodItem item) {
        return ResponseEntity.ok(service.addItem(item));
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }
}

