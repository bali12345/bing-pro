package com.bing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商城用户
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * PK
     */
    @TableId(value = "id")
    private String id;

    /**
     * 统一用户ID
     */
    @TableField(value = "one_id")
    private String oneId;

    /**
     * 所属租户
     */
    @TableField(value = "tenant_id")
    private String tenantId;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    @TableField(value = "del_flag")
    private String delFlag;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 用户编码
     */
    @TableField(value = "user_code")
    private Integer userCode;

    /**
     * 来源应用（MA：小程序；H5：普通H5；H5-WX：微信H5；APP：app；H5-PC：PC端H5）
     */
    @TableField(value = "app_type")
    private String appType;

    /**
     * 来源应用id
     */
    @TableField(value = "app_id")
    private String appId;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户等级（0：普通用户，1：普通会员）
     */
    @TableField(value = "user_grade")
    private Integer userGrade;

    /**
     * 当前积分
     */
    @TableField(value = "points_current")
    private Integer pointsCurrent;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 性别（1：男，2：女，0：未知）
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private String birthday;

    /**
     * 头像
     */
    @TableField(value = "headimg_url")
    private String headimgUrl;

    /**
     * 所在城市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 所在国家
     */
    @TableField(value = "country")
    private String country;

    /**
     * 所在省份
     */
    @TableField(value = "province")
    private String province;

    /**
     * 上级ID
     */
    @TableField(value = "parent_id")
    private String parentId;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 注册主体 H-MALL H-MEMBER
     */
    @TableField(value = "register_main_body")
    private String registerMainBody;

    /**
     * 最后一次登录时间
     */
    @TableField(value = "last_login_time")
    private Date lastLoginTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 省编码
     */
    @TableField(value = "province_code")
    private String provinceCode;

    /**
     * 区编码
     */
    @TableField(value = "county_code")
    private String countyCode;

    /**
     * 市编码
     */
    @TableField(value = "city_code")
    private String cityCode;

    /**
     * 注册店铺id
     */
    @TableField(value = "register_shop_id")
    private String registerShopId;

    /**
     * 邮箱
     */
    @TableField(value = "mail_box")
    private String mailBox;

    /**
     * 状态：0启用;1禁用
     */
    @TableField(value = "enable")
    private String enable;

    /**
     * 身份证号
     */
    @TableField(value = "id_number")
    private String idNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}