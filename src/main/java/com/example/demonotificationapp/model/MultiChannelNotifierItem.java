package com.example.demonotificationapp.model;

import com.example.demonotificationapp.model.base.NotificationItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class MultiChannelNotifierItem extends NotificationItem {
    private UUID externalId;
    private String phoneNumber;
    private String sender;
    private String receiver;
}
