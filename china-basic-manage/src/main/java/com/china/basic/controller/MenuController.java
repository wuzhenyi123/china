package com.china.basic.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.china.basic.aop.annotaions.VipPoints;
import com.china.basic.service.TbMenuService;
import com.china.common.common.ResultRespose;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(tags = "菜单接口")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private TbMenuService menuService;

    @GetMapping("/getMenuCode")
    @VipPoints(msg = "获取菜单")
    public ResultRespose<List<String>> getMenuCode() {
        log.info("获取菜单code");
        List<String> permissionList = StpUtil.getPermissionList();
        return ResultRespose.success(permissionList);
    }

    @PostMapping("/addMenu")
    @SaCheckPermission(value = "USER_MENU")
    public ResultRespose<List<String>> addMenu() {
        log.info("添加菜单");
        List<String> permissionList = StpUtil.getPermissionList();
        return ResultRespose.success(permissionList);
    }


}
