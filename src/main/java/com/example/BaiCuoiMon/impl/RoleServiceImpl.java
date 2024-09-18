package com.example.BaiCuoiMon.impl;

import com.example.BaiCuoiMon.Model.Category;
import com.example.BaiCuoiMon.Model.Role;
import com.example.BaiCuoiMon.Repository.RoleRepository;
import com.example.BaiCuoiMon.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findall() {
        return roleRepository.findAll();
    }
}
