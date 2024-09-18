package com.example.BaiCuoiMon.rest.controller;
import com.example.BaiCuoiMon.Model.Product;
import com.example.BaiCuoiMon.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;
    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.findall();
    }

    @GetMapping
    public Page<Product> getAllPaged(@PageableDefault(size = 5) Pageable pageable) {
        return productService.findallpage(pageable);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);
    }

}
