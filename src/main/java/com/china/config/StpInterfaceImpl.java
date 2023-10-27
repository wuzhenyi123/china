package com.china.config;

import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.fastjson2.JSON;
import com.china.common.ChinaContant;
import com.china.domain.TbMenu;
import com.china.domain.TbRole;
import com.china.mapper.TbMenuMapper;
import com.china.mapper.TbRoleMapper;
import com.china.mapper.TbUserMapper;
import com.china.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private TbRoleMapper roleMapper;

    @Autowired
    private TbMenuMapper menuMapper;
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        String menuListKey = ChinaContant.MENU_LIST_REDIS_KEY + loginId;
        String s = redisUtils.get(menuListKey);
        List<TbMenu> menuList;
        if (ObjectUtils.isEmpty(s)){
             menuList = menuMapper.getMenuByUserId((String) loginId);
            if (ObjectUtils.isEmpty(menuList)){
                return null;
            }
            String jsonString = JSON.toJSONString(menuList);
            redisUtils.set(menuListKey,jsonString, 3600L);
            return menuList.stream().map(TbMenu::getMenuCode).collect(Collectors.toList());
        }
        menuList = JSON.parseArray(s, TbMenu.class);
        return menuList.stream().map(TbMenu::getMenuCode).collect(Collectors.toList());
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<TbRole> tbRoles = roleMapper.selectRoleListByUserId((String) loginId);
        if (ObjectUtils.isEmpty(tbRoles)){
            return null;
        }
        return tbRoles.stream().map(TbRole::getRoleCode).collect(Collectors.toList());
    }
}
