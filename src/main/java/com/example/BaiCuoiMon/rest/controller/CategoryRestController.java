package com.example.BaiCuoiMon.rest.controller;

import com.example.BaiCuoiMon.Model.Category;
import com.example.BaiCuoiMon.Model.Product;
import com.example.BaiCuoiMon.Service.CategoryService;
import com.example.BaiCuoiMon.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController

public class CategoryRestController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/rest/categories")
    public List<Category> getall() {
        return categoryService.findall();
    }


}
