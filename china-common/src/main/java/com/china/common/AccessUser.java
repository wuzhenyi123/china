package com.china.common;

import lombok.Data;

/**
 * @Description: 用户信息
 * @Author: wuzhenyi
 * @CreateDate: 2023/11/5 19:57	//创建时间
 * @Version: 1.0	//版本号
 */
@Data
public class AccessUser {

       /**
        * 用户id
        */
       private String  userId;

    /**
     * 用户真实名称
     */
    private String realName ;
    
    /**
     * 用户手机号码
     */
    private String  phoneNum;
    
    /**
     * 用户名(登录用)
     */
    private String  userName;
}
