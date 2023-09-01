package com.bing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_network_topology_pon_area_day
 */
@TableName(value ="t_network_topology_pon_area_day")
@Data
public class TNetworkTopologyPonAreaDay implements Serializable {
    /**
     * 数据日期
     */
    @TableField(value = "data_time")
    private Date dataTime;

    /**
     * 省份简写
     */
    @TableField(value = "province")
    private String province;

    /**
     * OLT IP
     */
    @TableField(value = "olt_ip")
    private String oltIp;

    /**
     * ipv6前缀（MD5）
     */
    @TableField(value = "ipv6_prefix")
    private String ipv6Prefix;

    /**
     * PON口
     */
    @TableField(value = "olt_pon")
    private String oltPon;

    /**
     * 省份
     */
    @TableField(value = "province_name")
    private String provinceName;

    /**
     * 地市
     */
    @TableField(value = "city_name")
    private String cityName;

    /**
     * 区县
     */
    @TableField(value = "region_name")
    private String regionName;

    /**
     * 用户数
     */
    @TableField(value = "user_num")
    private Integer userNum;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}