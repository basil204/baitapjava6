package com.example.BaiCuoiMon.Service;

import com.example.BaiCuoiMon.Model.Category;
import com.example.BaiCuoiMon.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

     List<Category> findAll();

    List<Category> findall();
}
