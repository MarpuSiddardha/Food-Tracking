package com.siddardha.foodtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendExpiryAlert(String to, String itemName, LocalDate expiryDate) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Food Expiry Alert");
        message.setText("Dear User,\n\n" +
                "This is a reminder that your food item '" + itemName + "' is expiring on " + expiryDate + ".\n" +
                "Please take necessary actions to avoid wastage.\n\n" +
                "Best regards,\n" +
                "Food Tracker Team");
        mailSender.send(message);
    }
}

