package com.bing.constant;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public class Constants
{
    public static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;
    /**
     * 超时时长，单位毫秒
     */
    public static final int DEFAULT_TIMEOUT = 3000;
    public static final String USER_AGENT = "User-Agent";

    /**
     * 模拟 User-Agent
     */
    public static final String USER_AGENT_DATA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36 simple-http";


    /**
     * JSON
     */
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";


    /**
     * Content-Type
     */
    public static final String CONTENT_TYPE = "Content-Type";

    /**
     * Content-Encoding
     */
    public static final String CONTENT_ENCODING = "Content-Encoding";

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    public static final String DOT = ",";
    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP 远程方法调用
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS 远程方法调用
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 登录成功状态
     */
    public static final String LOGIN_SUCCESS_STATUS = "0";

    /**
     * 登录失败状态
     */
    public static final String LOGIN_FAIL_STATUS = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;


    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 演示手机号字典类型值
     */
    public static final String DEMO_PHONE_NUM_DICT_TYPE = "demo_phone_num";

    public static final String SYS_USER_SEX_DICT_TYPE = "sys_user_sex";
    public static final String SMS_REMOTE_INFO_HEADER_INNER = "INNER";

    public static final String INIT_PASSWORD = "123456";
    public static final String NEW_USERNAME = "新用户";
    public static final String SEX_DEFAULT = "2";
    public static final int VERIFICATION_CODE_LENGTH = 4;
    public static final String WEARING_CHECK_STRING_LOCK_PREFIX = "Wearing_Check_Lock_";
    public static final String DYNAMIC_BLOOD_SUGAR_MESSAGE_QUEUE = "dynamic_blood_sugar_message";
    public static final String DYNAMIC_BLOOD_SUGAR_MESSAGE_QUEUE_LOCK_SUFFIX = "_lock_suffix";
    public static final String DYNAMIC_BLOOD_SUGAR_PACKAGE_NUMBER_REDIS_PREDIX = "dynamic_blood_sugar_number_";
    public static final String DYNAMIC_BLOOD_SUGAR_WEARING_CODE_REDIS_PREDIX = "dynamic_blood_sugar_wearing_code_";
    public static final String DYNAMIC_BLOOD_SUGAR_PATIENT_REDIS_PREDIX = "dynamic_blood_sugar_patient_";
    public static final String DYNAMIC_BLOOD_SUGAR_CUSTOMIZE_MAX_COUNT_REDIS_KEY_PREFIX = "dynamic_blood_sugar_customize_max_count_int_";
    public static final String DYNAMIC_BLOOD_SUGAR_CUSTOMIZE_FIRST_DOT_TIME_REDIS_KEY_PREFIX = "dynamic_blood_sugar_customize_first_time_date_";
    public static final String DYNAMIC_BLOOD_SUGAR_CUSTOMIZE_MIN_COUNT_REDIS_KEY_PREFIX = "dynamic_blood_sugar_customize_min_count_int_";
    public static final String DYNAMIC_BLOOD_SUGAR_CUSTOMIZE_MAX_TIME_REDIS_KEY_PREFIX = "dynamic_blood_sugar_customize_max_time_date_";
    public static final String DYNAMIC_BLOOD_SUGAR_CUSTOMIZE_MIN_TIME_REDIS_KEY_PREFIX = "dynamic_blood_sugar_customize_min_time_date_";
    public static final String DYNAMIC_BLOOD_SUGAR_AWAIT_PUSH_ZSET_REDIS_PREDIX = "dynamic_blood_sugar_await_push_zset";
    public static final String DYNAMIC_BLOOD_SUGAR_SOS_MAX_COUNT_REDIS_KEY_PREFIX = "dynamic_blood_sugar_sos_max_count_int_";
    public static final String DYNAMIC_BLOOD_SUGAR_SOS_MAX_TIME_REDIS_KEY_PREFIX = "dynamic_blood_sugar_sos_max_time_date_";
    public static final String DYNAMIC_BLOOD_SUGAR_SOS_MIN_COUNT_REDIS_KEY_PREFIX = "dynamic_blood_sugar_sos_min_count_int_";
    public static final String DYNAMIC_BLOOD_SUGAR_SOS_MIN_TIME_REDIS_KEY_PREFIX = "dynamic_blood_sugar_sos_min_time_date_";

    public static final String DYNAMIC_BLOOD_SUGAR_SOS_ORIGINAL_LOWER_LIMIT_COUNT_REDIS_KEY_PREFIX = "dynamic_blood_sugar_soa_original_lower_limit_count_int_";
    public static final String DYNAMIC_BLOOD_SUGAR_SOS_ORIGINAL_LOWER_LIMIT_TIME_REDIS_KEY_PREFIX = "dynamic_blood_sugar_soa_original_lower_limit_time_int_";

    public final static String DYNAMIC_BLOOD_SUGAR_DIET_RECORD_EVENT = "dynamic_blood_sugar_diet_record_event";
    public final static String DYNAMIC_BLOOD_SUGAR_MEDICATION_RECORD_EVENT = "dynamic_blood_sugar_medication_record_event";
    public final static String DYNAMIC_BLOOD_SUGAR_REFERENCE_EVENT = "dynamic_blood_sugar_reference_event";
    public final static String DYNAMIC_BLOOD_SUGAR_PHYSICAL_EXERCISE_EVENT = "dynamic_blood_sugar_physical_exercise_event";
    public final static String DYNAMIC_BLOOD_SUGAR_MONITOR_WEARING_DAY ="wearingDay";
    public final static String DYNAMIC_BLOOD_SUGAR_MONITOR_WEARING_HOUR ="wearingHour";
    public final static String DYNAMIC_BLOOD_SUGAR_MONITOR_WEARING_START_TIME ="wearingStartTime";
    public final static String DYNAMIC_BLOOD_SUGAR_MONITOR_WEARING_END_TIME = "wearingEndTime";
    public static final String REDIS_KEY_PREFIX_RELATIVES_VERIFICATION_CODE = "relatives_verification_code_";
    public final static String DYNAMIC_MESSAGE_ADD_USER_MESSAGE = "dynamic_message_add_user_message";
    public final static String SYS_INFORMATION_CONTENT_SORT = "sys_information_content_sort";
    public final static String SYS_INFORMATION_PUBLISH_PLATFORM = "sys_information_publish_platform";
    //jsapi_ticket redisKey
    public final static String WX_JSAPI_TICKET = "wx_jsapi_ticket";
    //access_token redisKey
    public final static String WX_ACCESS_TOKEN = "wx_access_token";




    /**
     * 空字符串
     */
    public static final String EMPTY = "";
    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 定时任务白名单配置（仅允许访问的包名，如其他需要可以自行添加）
     */
    public static final String[] JOB_WHITELIST_STR = { "com.zqhk" };
    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "com.zqhk.common.core.utils.file" };
}
