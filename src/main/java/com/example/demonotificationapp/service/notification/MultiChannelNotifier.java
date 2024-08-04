package com.example.demonotificationapp.service.notification;

import com.example.demonotificationapp.model.EmailNotificationItem;
import com.example.demonotificationapp.model.base.NotificationItem;
import com.example.demonotificationapp.model.base.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(NotificationType.MULTI_CHANNEL_NOTIFIER)
@Slf4j
public class MultiChannelNotifier implements INotifier {

    private List<INotifier> notifiers;

    public MultiChannelNotifier(List<INotifier> notifiers) {
        this.notifiers = notifiers;
    }

    @Override
    public void send(NotificationItem item) {
        for (var notifier : notifiers) {
            notifier.send(item);
        }
    }
}
