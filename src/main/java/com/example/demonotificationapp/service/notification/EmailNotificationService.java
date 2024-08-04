package com.example.demonotificationapp.service.notification;

import com.example.demonotificationapp.model.EmailNotificationItem;
import com.example.demonotificationapp.model.base.NotificationItem;
import com.example.demonotificationapp.model.base.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service(NotificationType.EMAIL_NOTIFIER)
@Slf4j
public class EmailNotificationService implements INotifier {

    @Override
    public void send(NotificationItem item) {
        log.info("===Send Email Success===");
        log.info("Data={}", item);
    }
}
