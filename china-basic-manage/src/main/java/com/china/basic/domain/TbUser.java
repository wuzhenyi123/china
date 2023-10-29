package com.china.basic.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName tb_user
 */
@Data
public class TbUser implements Serializable {
    /**
     * 用户ID
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;


}