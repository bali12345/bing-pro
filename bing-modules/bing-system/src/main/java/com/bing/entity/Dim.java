package com.bing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dim")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Dim {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)//id自增
    private Integer id;

    @Column(name = "saleMonth")
    private String saleMonth;
    @Column(name = "region")
    private String region;
    @Column(name = "provinceName")
    private String provinceName;

//    td
//qlc
//df
//ks
//jk
//sp
//kn
//ltAndSz	total
    @Column(name = "ssq")
    private String ssq;
    @Column(name = "td")
    private String td;
    @Column(name = "qlc")
    private String qlc;
    @Column(name = "df")
    private String df;
    @Column(name = "ks")
    private String ks;
    @Column(name = "jk")
    private String jk;
    @Column(name = "sp")
    private String sp;
    @Column(name = "kn")
    private String kn;
    @Column(name = "ltAndSz")
    private String ltAndSz;
    @Column(name = "total")
    private String total;




}
