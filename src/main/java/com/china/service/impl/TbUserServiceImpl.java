package com.china.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.china.domain.TbUser;
import com.china.mapper.TbUserMapper;
import com.china.service.TbUserService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【tb_user(用户表)】的数据库操作Service实现
* @createDate 2023-10-25 23:16:23
*/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

}
