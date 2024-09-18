package com.example.BaiCuoiMon.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    Integer quantity;
    @ManyToOne
    @JoinColumn(name = "Productid")
    Product product;
    @ManyToOne
    @JoinColumn(name = "Orderid")
    Order order;
}
