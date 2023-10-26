package com.china.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.china.common.ResultRespose;
import com.china.dto.UserAddDto;
import com.china.service.TbUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "登录控制器")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private TbUserService userService;

    @PostMapping("/addUser")
    public ResultRespose<?> addUser(@RequestBody UserAddDto dto) {
        log.info("添加用户，dto:{}",dto);
         userService.addUser(dto);
        return ResultRespose.success("添加成功");
    }

    // 会话登录接口
    @GetMapping("/doLogin")
    public ResultRespose<SaTokenInfo> doLogin(String name, String pwd) {
        log.info("用户登录，userName:{}",name);
        SaTokenInfo saTokenInfo = userService.userLogin(name, pwd);
        return ResultRespose.success(saTokenInfo);
    }
    // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    @GetMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @GetMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/acc/logout
    @GetMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }
}
