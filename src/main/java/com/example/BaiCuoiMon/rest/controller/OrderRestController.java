package com.example.BaiCuoiMon.rest.controller;

import com.example.BaiCuoiMon.Model.Order;
import com.example.BaiCuoiMon.Service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public Order createOrder(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }
}
