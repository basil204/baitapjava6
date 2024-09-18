package com.example.BaiCuoiMon.Repository;

import com.example.BaiCuoiMon.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
