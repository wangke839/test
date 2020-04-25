package com.wangke.springcloud.shop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.ANY,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.ANY,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date outTime;
    @ManyToOne
    @JoinColumn(name = "province",referencedColumnName = "id",insertable = false,updatable = false)
    private Nation provinceBean;
    @ManyToOne
    @JoinColumn(name = "city",referencedColumnName = "id",insertable = false,updatable = false)
    private Nation cityBean;
    @ManyToOne
    @JoinColumn(name = "discover",referencedColumnName = "id",insertable = false,updatable = false)
    private Nation discoverBean;
}
