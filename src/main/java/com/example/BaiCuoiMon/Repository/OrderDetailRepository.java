package com.example.BaiCuoiMon.Repository;

import com.example.BaiCuoiMon.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
