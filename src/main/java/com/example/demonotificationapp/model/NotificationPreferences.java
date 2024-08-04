package com.example.demonotificationapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationPreferences {
    private Boolean emailEnabled;
    private Boolean smsEnabled;
    private Boolean pushEnabled;
}
