package com.china.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.china.basic.domain.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【tb_user(用户表)】的数据库操作Mapper
* @createDate 2023-10-25 23:16:23
* @Entity .domain.TbUser
*/
public interface TbUserMapper extends BaseMapper<TbUser> {

    TbUser getUserByUserId(@Param("userId") String userId);

    List<String> getMenuCodeByUserId(@Param("userId") String userId);
}