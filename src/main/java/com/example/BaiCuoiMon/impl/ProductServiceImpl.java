package com.example.BaiCuoiMon.impl;

import com.example.BaiCuoiMon.Model.Product;
import com.example.BaiCuoiMon.Repository.ProductRepository;
import com.example.BaiCuoiMon.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(String cid) {
        return productRepository.findByCategoryId(cid);
    }

    @Override
    public List<Product> findall() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findallpage(Pageable pageable) {
        return productRepository.findallpage(pageable);
    }


}
