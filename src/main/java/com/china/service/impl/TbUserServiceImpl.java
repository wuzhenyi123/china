package com.china.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.china.common.ChinaException;
import com.china.common.ChinaExceptionEnum;
import com.china.domain.TbUser;
import com.china.dto.UserAddDto;
import com.china.mapper.TbUserMapper;
import com.china.service.TbUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

/**
* @author Administrator
* @description 针对表【tb_user(用户表)】的数据库操作Service实现
* @createDate 2023-10-25 23:16:23
*/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    @Override
    public SaTokenInfo userLogin(String name, String pwd) {
        //密码加密对比
        String pwdSecure = SaSecureUtil.md5(pwd);
        LambdaQueryWrapper<TbUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TbUser::getUserName,name);
        wrapper.eq(TbUser::getPassword,pwdSecure);
        TbUser user = this.getOne(wrapper);
        if (ObjectUtils.isEmpty(user)){
            throw new ChinaException(ChinaExceptionEnum.PASSWORD_ERROR);
        }
        StpUtil.login(user.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return tokenInfo;
    }

    @Override
    public void addUser(UserAddDto dto) {
        TbUser tbUser = new TbUser();
        tbUser.setId(UUID.randomUUID().toString().replace("-",""));
        BeanUtils.copyProperties(dto,tbUser);
        tbUser.setPassword(SaSecureUtil.md5(dto.getPassword()));
        this.save(tbUser);
    }

}
