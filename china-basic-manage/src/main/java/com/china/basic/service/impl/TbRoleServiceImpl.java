package com.china.basic.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.china.basic.domain.TbRole;
import com.china.basic.mapper.TbRoleMapper;
import com.china.basic.service.TbRoleService;
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
