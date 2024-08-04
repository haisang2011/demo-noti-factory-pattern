package com.example.demonotificationapp.service.notification;

import com.example.demonotificationapp.model.UserProfile;
import com.example.demonotificationapp.model.base.NotificationType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationFactory {
    private final INotifier emailNotifier;
    private final INotifier smsNotifier;
    private final INotifier pushNotifier;

    public NotificationFactory(
            @Qualifier(NotificationType.EMAIL_NOTIFIER) INotifier emailNotifier,
            @Qualifier(NotificationType.SMS_NOTIFIER) INotifier smsNotifier,
            @Qualifier(NotificationType.PUSH_NOTIFIER) INotifier pushNotifier
    ) {
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
        this.pushNotifier = pushNotifier;
    }

    public INotifier createNotifier(String type) {
        return switch (type) {
            case NotificationType.EMAIL_NOTIFIER -> this.emailNotifier;
            case NotificationType.SMS_NOTIFIER -> this.smsNotifier;
            case NotificationType.PUSH_NOTIFIER -> this.pushNotifier;
            default -> throw new RuntimeException("type=" + type + " is not supported to send");
        };
    }

    public INotifier createNotifiers(UserProfile userProfile) {
        List<INotifier> notifiers = new ArrayList<>();

        if (userProfile.getNotificationPreferences().getEmailEnabled()) {
            notifiers.add(this.emailNotifier);
        }

        if (userProfile.getNotificationPreferences().getSmsEnabled()) {
            notifiers.add(this.smsNotifier);
        }

        if (userProfile.getNotificationPreferences().getPushEnabled()) {
            notifiers.add(this.pushNotifier);
        }

        return new MultiChannelNotifier(notifiers);
    }
}
