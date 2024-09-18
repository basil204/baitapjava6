package com.example.BaiCuoiMon.Repository;

import com.example.BaiCuoiMon.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o FROM Order o WHERE o.account.username =?1")
    List<Order> findByUserName(String username);
}
