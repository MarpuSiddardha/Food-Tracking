package com.siddardha.foodtracker.Scheduler;

import com.siddardha.foodtracker.Entity.FoodItem;
import com.siddardha.foodtracker.Service.FoodItemService;
import com.siddardha.foodtracker.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpiryCheckScheduler {
    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private NotificationService notificationService;

    @Scheduled(cron = "0 55 12 * * ?") // Every day at 9 AM
    public void checkExpiringItems() {
        List<FoodItem> items = foodItemService.getItemsExpiringSoon();
        for (FoodItem item : items) {
            notificationService.sendExpiryAlert(item.getUserEmail(), item.getName(), item.getExpiryDate());
        }
    }
}
