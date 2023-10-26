package com.china.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 * @TableName tb_role
 */
@Data
public class TbRole implements Serializable {
    /**
     * 主键
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
     * 编码
     */
    private String roleCode;

    /**
     * 名称
     */
    private String roleName;

    private static final long serialVersionUID = 1L;
}