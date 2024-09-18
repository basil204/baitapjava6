package com.example.BaiCuoiMon.Service;

import com.example.BaiCuoiMon.Model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
Account findById(String username);

    List<Account> findall();

    List<Account> getAdmin();


}
