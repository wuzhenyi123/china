package com.china.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.china.domain.TbUser;
import com.china.dto.UserAddDto;

/**
* @author Administrator
* @description 针对表【tb_user(用户表)】的数据库操作Service
* @createDate 2023-10-25 23:16:23
*/
public interface TbUserService extends IService<TbUser> {
    /**
     * 用户登录
     *
     * @param name
     * @param pwd
     * @return
     */
    SaTokenInfo userLogin(String name, String pwd);

    /**
     * 添加用户
     * @param dto
     */
    void addUser(UserAddDto dto);
}
