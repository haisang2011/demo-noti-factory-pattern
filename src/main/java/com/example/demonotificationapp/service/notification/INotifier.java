package com.example.demonotificationapp.service.notification;

import com.example.demonotificationapp.model.base.NotificationItem;

public interface INotifier {
    void send(NotificationItem item);
}
