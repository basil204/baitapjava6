package com.example.BaiCuoiMon.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Username", "Roleid"})
})
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne @JoinColumn(name = "Username")
    private Account account;
    @ManyToOne  @JoinColumn(name = "Roleid")
    private Role role;
}
