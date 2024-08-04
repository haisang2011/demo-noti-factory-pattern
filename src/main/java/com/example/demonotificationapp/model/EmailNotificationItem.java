package com.example.demonotificationapp.model;

import com.example.demonotificationapp.model.base.NotificationItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailNotificationItem extends NotificationItem {
    private String sender;
    private String receiver;
}
