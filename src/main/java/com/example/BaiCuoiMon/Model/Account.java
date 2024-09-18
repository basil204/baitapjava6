package com.example.BaiCuoiMon.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account implements Serializable {
    @Id
    @JsonProperty("Username")
    String username;
    @JsonProperty("Password")
    String password;
    String fullname;
    String email;
    String photo;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    List<Authority> authorities;
}
