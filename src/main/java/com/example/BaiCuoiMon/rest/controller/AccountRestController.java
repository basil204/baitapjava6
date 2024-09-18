package com.example.BaiCuoiMon.rest.controller;

import com.example.BaiCuoiMon.Model.Account;
import com.example.BaiCuoiMon.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAll(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return accountService.getAdmin();
        }
        return accountService.findall();
    }
}
