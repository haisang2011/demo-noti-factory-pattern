package com.example.demonotificationapp.dto;

import com.example.demonotificationapp.model.base.NotificationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequest {
    private Long userId;
    private List<String> items;
}
