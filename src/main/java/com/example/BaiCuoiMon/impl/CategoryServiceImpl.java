package com.example.BaiCuoiMon.impl;

import com.example.BaiCuoiMon.Model.Category;
import com.example.BaiCuoiMon.Model.Product;
import com.example.BaiCuoiMon.Repository.CategoryRepository;
import com.example.BaiCuoiMon.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findall() {
        return categoryRepository.findAll();
    }
}
