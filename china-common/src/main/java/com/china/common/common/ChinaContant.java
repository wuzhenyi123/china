package com.china.common.common;

public class ChinaContant {

    //---------------------缓存相关开始----------------------
    public static final String BASIC_REDIS_KEY="china:";
    /**
     * 菜单缓存前缀
     */
    public static final String MENU_LIST_REDIS_KEY = BASIC_REDIS_KEY +"user:menu:list:";
    //---------------------缓存相关结束----------------------

    //---------------------MQ相关开始----------------------
    /**
     * 用户积分交换机
     */
    public static final String VIP_POINTS_EXCHANGE = "china.user.vip.points.exchange";
    /**
     * 用户积分队列
     */
    public static final String VIP_POINTS_QUEUE = "china.user.vip.points.queue";
    //---------------------MQ相关结束----------------------
}
