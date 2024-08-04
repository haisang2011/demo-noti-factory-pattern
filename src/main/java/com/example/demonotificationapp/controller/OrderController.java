package com.example.demonotificationapp.controller;

import com.example.demonotificationapp.dto.OrderRequest;
import com.example.demonotificationapp.dto.OrderResponse;
import com.example.demonotificationapp.model.EmailNotificationItem;
import com.example.demonotificationapp.model.MultiChannelNotifierItem;
import com.example.demonotificationapp.model.NotificationPreferences;
import com.example.demonotificationapp.model.UserProfile;
import com.example.demonotificationapp.model.base.NotificationType;
import com.example.demonotificationapp.service.notification.NotificationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final NotificationFactory factory;

    private List<UserProfile> userProfileList = List.of(
            new UserProfile(
                    1L,
                    "Sang Nguyen",
                    "sang.nguyen98@gmail.com",
                    "0986271812",
                    new NotificationPreferences(true, true, true)),
            new UserProfile(
                    2L,
                    "Kim Tien",
                    "kimtien@gmail.com",
                    "0311999001",
                    new NotificationPreferences(true, true, false))
    );

    @PostMapping
    public ResponseEntity<OrderResponse> order(@RequestBody OrderRequest request) {
        UserProfile userProfile = userProfileList.stream()
                .filter(entity -> entity.getUserId().equals(request.getUserId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find user profile"));

        boolean isOrderSuccess = saveOrder(request);
        if (!isOrderSuccess) {
            throw new RuntimeException("Failed to make an order");
        }

        var multiChannelNotifier = factory.createNotifiers(userProfile);
        MultiChannelNotifierItem item = new MultiChannelNotifierItem(
                UUID.randomUUID(),
                userProfile.getPhoneNumber(),
                "me@gmail.com",
                userProfile.getEmail()
        );
        item.setId(1L);
        item.setMessage("You just made an order successfully!");
        item.setCreatedDateTime(LocalDateTime.now());
        multiChannelNotifier.send(item);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(UUID.randomUUID());
        orderResponse.setUserId(request.getUserId());
        orderResponse.setStatus("ORDERED");
        return ResponseEntity.ok(orderResponse);
    }

    private boolean saveOrder(OrderRequest request) {
        // Do nothing
        return true;
    }
}
