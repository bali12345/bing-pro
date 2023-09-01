package com.bing.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Entity
@Table(name = "info")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Info {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)//id自增
    private Integer id;

    @Column(name = "name")
    private String username;

    @Column(name = "age")
    private Integer age;

    @Column(name = "create_time")
    private Date createTime;
}
