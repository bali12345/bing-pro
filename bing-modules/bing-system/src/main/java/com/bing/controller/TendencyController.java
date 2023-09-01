package com.bing.controller;

import cn.hutool.json.JSONUtil;
import com.bing.controller.dto.TendencyDTO;
import com.bing.controller.vo.TendencyVO;
import com.bing.domain.R;
import com.bing.entity.TNetworkTopologyPonAreaDay;
import com.bing.ienum.HandlingSuggestionTypeEnum;
import com.bing.service.TNetworkTopologyPonAreaDayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/tendency")
public class TendencyController {

    @Resource
    private TNetworkTopologyPonAreaDayService tNetworkTopologyPonAreaDayService;


    @GetMapping("/all")
    public R<List<TendencyVO>> selectUserAll(@RequestBody TendencyDTO dto){
        List<TendencyVO> voList = tNetworkTopologyPonAreaDayService.getTendencyList(dto);
        return R.ok(voList);
    }

    public static void main(String[] args) {
        /*StringBuilder result = new StringBuilder();
        String left = "1,0,1,1,1,1";
        List<String> handlingSuggestionLeft = Arrays.stream(left.split(",")).limit(5).collect(Collectors.toList());
        List<String> handlingSuggestionStrList = new ArrayList<>();
        handlingSuggestionStrList.add("VAG激光");
        handlingSuggestionStrList.add("玻璃体消融术");
        handlingSuggestionStrList.add("下睑内翻矫正术");
        handlingSuggestionStrList.add("PEA+IOL");
        handlingSuggestionStrList.add("胬肉切除+羊膜移植");
        for (int j = 0; j < 5; j++) {
            if (handlingSuggestionLeft.get(j).equals("1")){
                result.append(",").append(handlingSuggestionStrList.get(j));
            }
        }
        result.replace(0,1,"");*/

        String left = "0,0,0,1,1,0";
        List<String> handlingSuggestionLeft = Arrays.stream(left.split(","))
                .limit(5)
                .collect(Collectors.toList());

        String lastCharacter = String.valueOf(left.charAt(left.length() - 1));
        System.out.println(lastCharacter);
        Map<String, String> handlingSuggestionStrMap = HandlingSuggestionTypeEnum.toMap();
        List<String> handlingSuggestionStrList = HandlingSuggestionTypeEnum.getLabelList();

        String result = IntStream.range(0, 5)
                .filter(j -> "1".equals(handlingSuggestionLeft.get(j)))
                .mapToObj(handlingSuggestionStrList::get)
                .map(handlingSuggestionStrMap::get)
                .collect(Collectors.joining(","));
        List<String> list = Arrays.asList(result.split(","));

        /*if (result.length() > 0) {
            result.deleteCharAt(0);
        }*/
        System.out.println(JSONUtil.toJsonStr(list));
    }
}
