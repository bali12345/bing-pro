package com.bing.ienum;


import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public enum HandlingSuggestionTypeEnum {
    VAG("01","VAG激光"),
    GLASS("02","玻璃体消融术"),
    EYELID_CORRECTION("03","下睑内翻矫正术"),
    PEA_IOL("04","PEA+IOL"),
    LESION_REMOVAL_AMNION("05","胬肉切除+羊膜移植");

    private final String code;

    private final String label;

    HandlingSuggestionTypeEnum(String code, String label) {
        this.label = label;
        this.code = code;
    }

    public static Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        for (HandlingSuggestionTypeEnum type : HandlingSuggestionTypeEnum.values()) {
            map.put(type.getLabel(), type.getCode());
        }
        return map;
    }


    public static List<String> getLabelList() {
        List<String> labelList = new ArrayList<>();
        for (HandlingSuggestionTypeEnum type : HandlingSuggestionTypeEnum.values()) {
            labelList.add(type.getLabel());
        }
        return labelList;
    }
}
