package com.example.BaiCuoiMon.impl;

import com.example.BaiCuoiMon.Model.Account;
import com.example.BaiCuoiMon.Repository.AccountRepository;
import com.example.BaiCuoiMon.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(String username) {
        return accountRepository.findById(username).get();
    }

    @Override
    public List<Account> findall() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAdmin() {
        return accountRepository.getAdmin();
    }
}
