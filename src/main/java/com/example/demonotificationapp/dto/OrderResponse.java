package com.example.demonotificationapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderResponse {
    private UUID orderId;
    private Long userId;
    private String status;
}
