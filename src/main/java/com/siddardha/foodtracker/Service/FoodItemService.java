package com.siddardha.foodtracker.Service;

import com.siddardha.foodtracker.Entity.FoodItem;
import com.siddardha.foodtracker.Repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository repository;

    public FoodItem addItem(FoodItem item) {
        return repository.save(item);
    }

    public List<FoodItem> getAllItems() {
        return repository.findAll();
    }

    public List<FoodItem> getItemsExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate inThreeDays = today.plusDays(3);
        return repository.findByExpiryDateBetween(today, inThreeDays);
    }
}
