package com.example.demonotificationapp.model;

import com.example.demonotificationapp.model.base.NotificationItem;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class PushNotificationItem extends NotificationItem {
    private UUID externalId;
}
