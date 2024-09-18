package com.example.BaiCuoiMon.Controller;

import com.example.BaiCuoiMon.Model.Product;
import com.example.BaiCuoiMon.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class HomeController {

    @RequestMapping({"/home/index","/"})
    public String home(Model model) {

        return "redirect:/product/list";
    }
    @RequestMapping({"/admin/index","/admin","/admin/home"})
    public String admin(Model model) {

        return "redirect:/assets/admin/index.html";
    }

}
