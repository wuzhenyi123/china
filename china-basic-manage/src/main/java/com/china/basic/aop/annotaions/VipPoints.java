package com.china.basic.aop.annotaions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 会员增加积分注解
 * @Author: wuzhenyi
 * @CreateDate: 2023/11/5 22:37	//创建时间
 * @Version: 1.0	//版本号
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VipPoints {
    String msg() default "";
}
