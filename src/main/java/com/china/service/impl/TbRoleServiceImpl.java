package com.china.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.china.domain.TbRole;
import com.china.mapper.TbRoleMapper;
import com.china.service.TbRoleService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【tb_role(角色表)】的数据库操作Service实现
* @createDate 2023-10-26 22:46:33
*/
@Service
public class TbRoleServiceImpl extends ServiceImpl<TbRoleMapper, TbRole>
implements TbRoleService{

}
