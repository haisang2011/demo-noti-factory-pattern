package com.example.demonotificationapp.model;

import com.example.demonotificationapp.model.base.NotificationItem;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmsNotificationItem extends NotificationItem {
    private String phoneNumber;
}
