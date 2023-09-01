package com.bing.service;

import com.bing.controller.dto.TendencyDTO;
import com.bing.controller.vo.TendencyVO;
import com.bing.entity.TNetworkTopologyPonAreaDay;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 胡帅冰
* @description 针对表【t_network_topology_pon_area_day】的数据库操作Service
* @createDate 2023-07-11 09:13:55
*/
public interface TNetworkTopologyPonAreaDayService extends IService<TNetworkTopologyPonAreaDay> {

    List<TendencyVO> getTendencyList(TendencyDTO dto);
}
