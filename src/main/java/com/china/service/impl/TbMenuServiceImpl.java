package com.china.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.china.domain.TbMenu;
import com.china.mapper.TbMenuMapper;
import com.china.service.TbMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【tb_menu(菜单表)】的数据库操作Service实现
* @createDate 2023-10-24 22:31:49
*/
@Slf4j
@Service
public class TbMenuServiceImpl extends ServiceImpl<TbMenuMapper, TbMenu> implements TbMenuService {

}
