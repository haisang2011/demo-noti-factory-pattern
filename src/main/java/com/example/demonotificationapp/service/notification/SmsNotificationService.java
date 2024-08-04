package com.example.demonotificationapp.service.notification;

import com.example.demonotificationapp.model.EmailNotificationItem;
import com.example.demonotificationapp.model.PushNotificationItem;
import com.example.demonotificationapp.model.SmsNotificationItem;
import com.example.demonotificationapp.model.base.NotificationItem;
import com.example.demonotificationapp.model.base.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service(NotificationType.SMS_NOTIFIER)
@Slf4j
public class SmsNotificationService implements INotifier {

    @Override
    public void send(NotificationItem item) {
        log.info("===Send Sms Success===");
        log.info("Data={}", item);
    }
}
