package com.example.BaiCuoiMon.impl;

import com.example.BaiCuoiMon.Model.Account;
import com.example.BaiCuoiMon.Model.Authority;
import com.example.BaiCuoiMon.Repository.AccountRepository;
import com.example.BaiCuoiMon.Repository.AuthorityRepository;
import com.example.BaiCuoiMon.Service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Authority> getfindauthorityOfAdmin() {
        List<Account> account = accountRepository.getAdmin();
        return authorityRepository.authoritiesOf(account);
    }

    @Override
    public List<Authority> findall() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority create(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void delete(Integer id) {
        authorityRepository.deleteById(id);
    }
}
