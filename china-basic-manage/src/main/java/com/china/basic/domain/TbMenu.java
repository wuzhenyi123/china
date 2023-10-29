package com.china.basic.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单表
 * @TableName tb_menu
 */
@Data
public class TbMenu implements Serializable {
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
     * 名称
     */
    private String menuName;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 父节点
     */
    private String parentId;

    /**
     * 节点类型，1文件夹，2页面，3按钮
     */
    private Integer nodeType;

    /**
     * 图标地址
     */
    private String iconUrl;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 页面对应的地址
     */
    private String linkUrl;

    /**
     * 层次
     */
    private Integer menuLevel;

    /**
     * 树id的路径 整个层次上的路径id，/分隔，想要找父节点特别快
     */
    private String menuPath;


}