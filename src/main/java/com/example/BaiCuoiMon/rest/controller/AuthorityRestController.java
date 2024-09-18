package com.example.BaiCuoiMon.rest.controller;

import com.example.BaiCuoiMon.Model.Account;
import com.example.BaiCuoiMon.Model.Authority;
import com.example.BaiCuoiMon.Service.AccountService;
import com.example.BaiCuoiMon.Service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {

    @Autowired
    AuthorityService authorityService;

    @GetMapping
    public List<Authority> getAll(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return authorityService.getfindauthorityOfAdmin();
        }
        return authorityService.findall();
    }
    @PostMapping
    public Authority addAuthority(@RequestBody Authority authority) {
        return authorityService.create(authority);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityService.delete(id);
    }
}
