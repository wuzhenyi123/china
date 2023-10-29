package com.china.common.common;

import lombok.Data;

@Data
public class ChinaException extends RuntimeException{
    private Integer code;
    private String message;

    public ChinaException() {
    }

    public ChinaException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ChinaException(ChinaExceptionEnum chinaExceptionEnum) {
        super(chinaExceptionEnum.getMessage());
        this.code = chinaExceptionEnum.getCode();
        this.message = chinaExceptionEnum.getMessage();
    }
}
