package com.china.basic.aop.aspect;

import cn.dev33.satoken.stp.StpUtil;
import com.china.basic.aop.annotaions.VipPoints;
import com.china.basic.rabbitMq.BasicMqSender;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @Description: 会员增加积分切面
 * @Author: wuzhenyi
 * @CreateDate: 2023/11/5 22:40	//创建时间
 * @Version: 1.0	//版本号
 */
@Aspect
@Component
public class VipPointsAspect {
    @Autowired
    private BasicMqSender mqSender;

    @Pointcut("@annotation(com.china.basic.aop.annotaions.VipPoints)")
    public void vipPointsPointCut(){

    };

    @After("vipPointsPointCut() && @annotation(vipAnnoation)")
    public void after(VipPoints vipAnnoation){
        System.out.println("============ 用户增加积分切面开始增加积分操作 ==========");
        String msg = vipAnnoation.msg();

        //获取用户id
        String loginId = (String) StpUtil.getLoginId();
        mqSender.sendVipPoints(loginId+ " :  "+ msg);

    }

}
