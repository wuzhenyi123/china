package com.china.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.china.common.ResultRespose;
import com.china.service.TbMenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResultRespose<List<String>> getMenuCode() {
        log.info("获取菜单code");
        List<String> permissionList = StpUtil.getPermissionList();
        return ResultRespose.success(permissionList);
    }


}
