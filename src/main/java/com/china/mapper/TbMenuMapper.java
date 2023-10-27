package com.china.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.china.domain.TbMenu;
import org.apache.ibatis.annotations.Param;

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
