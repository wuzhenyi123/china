package com.china.common.common;

import lombok.Data;

@Data
public class ResultRespose<T> {
    // 默认成功
    private boolean success = true;

    // 默认成功的状态码为0
    private Integer code = 0;

    // 返回的消息,默认成功
    private String message = "操作成功!";

    // 保存任何数据类型的数据
    private Object data;


    public ResultRespose() {
    }


    public ResultRespose(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultRespose(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ResultRespose(boolean success, Integer code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultRespose success(){
        return new ResultRespose();
    }

    public static ResultRespose success(Integer code, String message){
        ResultRespose ResultRespose = new ResultRespose();
        ResultRespose.setMessage(message);
        ResultRespose.setCode(code);
        return ResultRespose;
    }

    public static ResultRespose success(Integer code, String message, Object data){
        ResultRespose ResultRespose = new ResultRespose();
        ResultRespose.setMessage(message);
        ResultRespose.setCode(code);
        ResultRespose.setData(data);
        return ResultRespose;
    }

    public static ResultRespose success(Object data){
        ResultRespose ResultRespose = new ResultRespose();
        ResultRespose.setData(data);
        return ResultRespose;
    }

    public static ResultRespose error(ChinaExceptionEnum chinaExceptionEnum){
        ResultRespose ResultRespose = new ResultRespose();
        ResultRespose.setSuccess(false);
        ResultRespose.setMessage(chinaExceptionEnum.getMessage());
        ResultRespose.setCode(ResultRespose.getCode());
        return ResultRespose;
    }

    public static ResultRespose error(Integer code, String message){
        ResultRespose ResultRespose = new ResultRespose();
        ResultRespose.setSuccess(false);
        ResultRespose.setMessage(message);
        ResultRespose.setCode(code);
        return ResultRespose;
    }

    public static ResultRespose error(Integer code, String message, Object data){
        ResultRespose ResultRespose = new ResultRespose();
        ResultRespose.setSuccess(false);
        ResultRespose.setMessage(message);
        ResultRespose.setCode(code);
        ResultRespose.setData(data);
        return ResultRespose;
    }




    // 构建链式语法
    public ResultRespose setSuccess(boolean success){
        this.success = success;
        return this;
    }

    public ResultRespose setMessage(String message){
        this.message = message;
        return this;
    }

    public ResultRespose setCode(Integer code){
        this.code = code;
        return this;
    }

    public ResultRespose setResultObj(Object data){
        this.data = data;
        return this;
    }
}
