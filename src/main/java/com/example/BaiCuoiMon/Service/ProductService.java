package com.example.BaiCuoiMon.Service;

import com.example.BaiCuoiMon.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();


    Product findById(Integer id);

    List<Product> findByCategoryId(String cid);

    List<Product> findall();

    Product save(Product product);

    Product update(Product product);

    void delete(Integer id);


    Page<Product> findallpage(Pageable pageable);
}
