package com.example.BaiCuoiMon.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    String id;
    String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    List<Product> products;
}
