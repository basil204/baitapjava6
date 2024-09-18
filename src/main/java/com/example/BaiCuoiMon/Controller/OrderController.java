package com.example.BaiCuoiMon.Controller;

import com.example.BaiCuoiMon.Service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/checkout")
    public String checkout() {
        return "order/checkout";
    }
    @GetMapping("/list")
    public String list(Model model ) {
        // Lấy thông tin người dùng đang đăng nhập
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Sử dụng tên người dùng để tìm các đơn hàng của họ
        model.addAttribute("orders", orderService.findByUsername(username));
        return "order/list";

    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        return "order/detail";
    }

}
