package com.bing.controller.vo;

import lombok.Data;

@Data
public class TendencyVO {


    /**
     * 日期
     */
    private String date;

    /**
     * 活跃PON口数
     */
    private Integer activeNum;
    /**
     * 极限PON口数
     */
    private Integer outdoNum;
    /**
     * 累计占比
     */
    private Double addUpRate;
    /**
     * 日均占比
     */
    private Double dayAvgRate;
}
