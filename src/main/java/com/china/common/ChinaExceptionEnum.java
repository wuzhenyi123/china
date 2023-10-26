package com.china.common;

import lombok.Getter;

@Getter
public enum ChinaExceptionEnum {

    // 1. 字段(枚举实例)
    ERROR(-1, "系统异常,请稍后再试!"),

    SUCCESS(0, "操作成功!"),

    NOT_LOGIN(401,"未登录！"),

    PASSWORD_ERROR(100010,"密码错误！"),
    PARAM_ERROR(100011,"参数错误！"),
    LOIN_ERROR(100012,"登录失败！"),
    ;


    // 2. 枚举实例
    private Integer code; // 错误码
    private String message; // 错误码对应的错误信息提示语

    // 3. 字段的构造方法


    ChinaExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
