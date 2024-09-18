package com.example.BaiCuoiMon.store;

import com.example.BaiCuoiMon.Model.Account;
import com.example.BaiCuoiMon.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;


import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AccountService accountService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http    .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/order/**").authenticated()
                                .requestMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
                                .requestMatchers("/rest/authorities").hasRole("DIRE")
                                .anyRequest().permitAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/security/login/form")
                                .loginProcessingUrl("/security/login")
                                .defaultSuccessUrl("/security/login/success", false)
                                .failureUrl("/security/login/failure")
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/security/logoff")
                                .logoutSuccessUrl("/security/login/success")
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedPage("/security/unauthorized")
                );


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                Account user = accountService.findById(username);
                if (user == null) {
                    throw new UsernameNotFoundException(username + " not found");
                }
                String password = passwordEncoder().encode(user.getPassword());
                String[] roles = user.getAuthorities().stream()
                        .map(er -> er.getRole().getId())
                        .collect(Collectors.toList()).toArray(new String[0]);
                return User.withUsername(username).password(password).roles(roles).build();
            } catch (NoSuchElementException e) {
                throw new UsernameNotFoundException(username + " not found");
            }
        });
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(HttpMethod.OPTIONS,"/**");
    }
}
