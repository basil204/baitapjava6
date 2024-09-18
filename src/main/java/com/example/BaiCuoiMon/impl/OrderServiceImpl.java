package com.example.BaiCuoiMon.impl;

import com.example.BaiCuoiMon.Model.Order;
import com.example.BaiCuoiMon.Model.OrderDetail;
import com.example.BaiCuoiMon.Repository.OrderDetailRepository;
import com.example.BaiCuoiMon.Repository.OrderRepository;
import com.example.BaiCuoiMon.Service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Order orderObj = mapper.convertValue(orderData, Order.class);
            orderRepository.save(orderObj);

            TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
            List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
                    .stream().peek(d -> d.setOrder(orderObj)).collect(Collectors.toList());
            orderDetailRepository.saveAll(details);
            return orderObj;
        } catch (Exception e) {
            throw new RuntimeException("Order creation failed", e);
        }
    }

    @Override
    public Object findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return orderRepository.findByUserName(username);
    }
}


