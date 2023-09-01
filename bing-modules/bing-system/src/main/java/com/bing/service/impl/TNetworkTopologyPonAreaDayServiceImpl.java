package com.bing.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.controller.dto.TendencyDTO;
import com.bing.controller.vo.TendencyVO;
import com.bing.entity.TNetworkTopologyPonAreaDay;
import com.bing.service.TNetworkTopologyPonAreaDayService;
import com.bing.mapper.TNetworkTopologyPonAreaDayMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 胡帅冰
 * @description 针对表【t_network_topology_pon_area_day】的数据库操作Service实现
 * @createDate 2023-07-11 09:13:55
 */
@Service
public class TNetworkTopologyPonAreaDayServiceImpl extends ServiceImpl<TNetworkTopologyPonAreaDayMapper, TNetworkTopologyPonAreaDay>
    implements TNetworkTopologyPonAreaDayService{


    @Override
    public List<TendencyVO> getTendencyList(TendencyDTO dto) {
        baseMapper.selectPage(null,null);
        //time类型 月 yyyy  日 yyyy-MM

        List<TendencyVO> list = new ArrayList<>();
        Integer threshold = dto.getThreshold();
        String dataTime3 = dto.getDateTime();
        String provinceStr = Objects.isNull(dto.getProvince()) ? "" : dto.getProvince();
        String cityStr = Objects.isNull(dto.getCity()) ? "" : dto.getCity();
        String regionStr = Objects.isNull(dto.getRegion()) ? "" : dto.getRegion();

        //日 yyyy-MM
        if (dataTime3.length() == 6) {
            LambdaQueryWrapper<TNetworkTopologyPonAreaDay> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(StrUtil.isNotBlank(provinceStr),TNetworkTopologyPonAreaDay::getProvince,provinceStr);
            wrapper.eq(StrUtil.isNotBlank(cityStr),TNetworkTopologyPonAreaDay::getCityName,cityStr);
            wrapper.eq(StrUtil.isNotBlank(regionStr),TNetworkTopologyPonAreaDay::getRegionName,regionStr);
            wrapper.le(TNetworkTopologyPonAreaDay::getUserNum,threshold);
//            baseMapper.selectTotalUserNum();
            List<TNetworkTopologyPonAreaDay> tNetworkTopologyPonAreaDays = baseMapper.selectList(wrapper);
        }else {
            //月粒度



        }


        return null;
    }
}




