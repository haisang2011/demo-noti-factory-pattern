package com.example.demonotificationapp;

import com.example.demonotificationapp.controller.OrderController;
import com.example.demonotificationapp.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoNotificationAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoNotificationAppApplication.class, args);
    }

    @Autowired
    private OrderController controller;

    @Override
    public void run(String... args) throws Exception {
        controller.order(new OrderRequest(2L, List.of("Iphone 15 Promax","Headphone WHXM5")));
    }
}
