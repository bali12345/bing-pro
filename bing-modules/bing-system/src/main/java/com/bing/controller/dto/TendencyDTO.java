package com.bing.controller.dto;

import lombok.Data;

@Data
public class TendencyDTO {


    private String dateTime;

    private Integer threshold = 64;

    private String province;

    private String city;

    private String region;

}
