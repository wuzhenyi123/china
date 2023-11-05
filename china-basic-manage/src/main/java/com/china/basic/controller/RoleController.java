package com.china.basic.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.china.common.common.ResultRespose;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 权限管理接口
 * @Author: wuzhenyi
 * @CreateDate: 2023/11/5 19:47	//创建时间
 * @Version: 1.0	//版本号
 */
@Slf4j
@Api(tags = "菜单接口")
@RestController
@RequestMapping("/role")
public class RoleController {

    @PostMapping("/addRole")
    @SaCheckRole(value = "admin")
    public ResultRespose<?> addMenu() {
        log.info("添加权限");
        List<String> permissionList = StpUtil.getPermissionList();
        return ResultRespose.success();
    }
}
