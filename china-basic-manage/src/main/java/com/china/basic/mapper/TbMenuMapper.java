package com.china.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.china.basic.domain.TbMenu;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【tb_menu(菜单表)】的数据库操作Mapper
* @createDate 2023-10-24 22:31:49
* @Entity generator.domain.TbMenu
*/
public interface TbMenuMapper extends BaseMapper<TbMenu> {


    List<TbMenu> getMenuByUserId(@Param("userId") String userId);
}
