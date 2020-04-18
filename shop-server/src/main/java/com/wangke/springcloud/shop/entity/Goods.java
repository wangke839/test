package com.wangke.springcloud.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "goods")
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String picture;
    private BigDecimal price;
    private Integer sales;
    private Integer province;
    private Integer city;
    private Integer discover;
}
