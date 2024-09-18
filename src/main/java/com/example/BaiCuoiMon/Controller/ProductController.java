package com.example.BaiCuoiMon.Controller;

import com.example.BaiCuoiMon.Model.Product;
import com.example.BaiCuoiMon.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public String view(Model model,@RequestParam("cid") Optional<String> cid){
        if(cid.isPresent()){
            List<Product> list = productService.findByCategoryId(cid.get());
            model.addAttribute("products", list);
        }else {
            List<Product> list = productService.getAllProducts();
            model.addAttribute("products", list);
        }

        return "product/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Product item = productService.findById(id);
        model.addAttribute("item", item);
        return "product/detail";
    }
}
