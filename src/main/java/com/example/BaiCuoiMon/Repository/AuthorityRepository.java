package com.example.BaiCuoiMon.Repository;

import com.example.BaiCuoiMon.Model.Account;
import com.example.BaiCuoiMon.Model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
   @Query("SELECT distinct a from Authority a where a.account in ?1")
    List<Authority> authoritiesOf(List<Account> account);
}
