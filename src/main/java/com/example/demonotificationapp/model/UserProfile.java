package com.example.demonotificationapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfile {
    private Long userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private NotificationPreferences notificationPreferences;
}
