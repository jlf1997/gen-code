package com.cecii.common;

/**
 * 通用常量信息
 * 
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";
    
    /**
     * 默认周期
     */
    public static final Long DEFAULT_CYCLE_TIME = 1l;

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static String AUTO_REOMVE_PRE = "true";

    /**
     * 当前记录起始索引
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static String IS_ASC = "asc";
    
    public static String IS_DESC = "desc";
    
    public static String IS_ASC_COLUMN = "isAsc";
    
    //中国地址 code
    public static Integer CHINA_CODE = 1;
    
    public static String NEWS_LABEL_NAME = "sys_new_label";
    
    public static String NEWS_TYPE_NAME = "sys_news_type";
    
    //收藏
    public static Integer IS_COLLECT = 1;
    
    //没有收藏
    public static Integer IS_NOT_COLLECT = 0;
    
    //点赞
    public static Integer IS_LIKE = 1;
    
    //取消点赞
    public static Integer IS_NOT_LIKE = 0;
    
    //一个手机号当天只发送三次
    public static Integer REGISTER_SEND_CODE_TIMES = 3;
}
