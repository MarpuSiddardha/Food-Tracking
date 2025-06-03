package com.siddardha.foodtracker.Repository;

import com.siddardha.foodtracker.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findByExpiryDateBetween(LocalDate start, LocalDate end);
}
