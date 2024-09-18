package com.example.BaiCuoiMon.Service;

import com.example.BaiCuoiMon.Model.Order;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService  {
    Order create(JsonNode orderData);


    Object findById(Long id);

    List<Order> findByUsername(String username);
}
