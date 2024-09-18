package com.example.BaiCuoiMon.Repository;

import com.example.BaiCuoiMon.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("select distinct ar.account from Authority ar where ar.role.id in ('dire','staf')")
    List<Account> getAdmin();
}
