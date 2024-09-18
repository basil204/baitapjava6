package com.example.BaiCuoiMon.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class ShopingCartController {

    @GetMapping("/view")
    public String view() {
        return "cart/view";
    }
}
