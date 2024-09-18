package com.example.BaiCuoiMon.rest.controller;


import com.example.BaiCuoiMon.Model.Role;
import com.example.BaiCuoiMon.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class RoleRestController {
    @Autowired
    RoleService roleService;
    @GetMapping("/roles")
    public List<Role> getall() {
        return roleService.findall();
    }


}
