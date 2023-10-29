package com.china.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.china.basic.domain.TbRole;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【tb_role(角色表)】的数据库操作Mapper
* @createDate 2023-10-26 22:46:33
* @Entity com.china.domain.TbRole
*/
public interface TbRoleMapper extends BaseMapper<TbRole> {


    List<TbRole> selectRoleListByUserId(@Param("userId") String userId);
}
