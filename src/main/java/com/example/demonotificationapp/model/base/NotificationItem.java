package com.example.demonotificationapp.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@ToString
public abstract class NotificationItem {
    private Long id;
    private String message;
    private LocalDateTime createdDateTime;
    private String phoneNumber;
    private UUID externalId;
    private String sender;
    private String receiver;
}
