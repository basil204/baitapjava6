package com.example.BaiCuoiMon.Service;

import com.example.BaiCuoiMon.Model.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> getfindauthorityOfAdmin();

    List<Authority> findall();

    Authority create(Authority authority);

    void delete(Integer id);
}
