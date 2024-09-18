package com.example.BaiCuoiMon.Repository;

import com.example.BaiCuoiMon.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    List<Product> findByCategoryId(String cid);

    @Query("SELECT p FROM Product p")
    Page<Product> findallpage(Pageable pageable);
}
