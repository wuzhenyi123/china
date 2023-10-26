package com.china.common;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ChinaExceptionHandler {
    /**
     * 处理系统异常
     * @return
     *
     * catch (Exception e) {
     *             e.printStackTrace();
     *             return AjaxResult.me().setSuccess(false).setMessage("系统繁忙，请重试！");
     *         }
     */
    @ExceptionHandler(Exception.class) //这句代码可以认为是trycatch中的catch
    public ResultRespose exceptionHandler(Exception e){
        e.printStackTrace();
        return ResultRespose.error(ChinaExceptionEnum.ERROR.getCode(), ChinaExceptionEnum.ERROR.getMessage());
    }

    /**
     * 处理自定义业务异常
     * @return
     *
     * catch (ChinaException e) {
     *             e.printStackTrace();
     *             return AjaxResult.me().setSuccess(false).setMessage("系统繁忙，请重试！");
     *         }
     */
    @ExceptionHandler(ChinaException.class) //这句代码可以认为是trycatch中的catch
    public ResultRespose ChinaExceptionHandler(ChinaException e){
        e.printStackTrace();
        return ResultRespose.error(e.getCode(), e.getMessage());
    }


    /**
     * 处理校验对象时候的异常MethodArgumentNotValidException
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultRespose ChinaExceptionHandler(MethodArgumentNotValidException e){
        e.printStackTrace();
        // ((BeanPropertyBindingResult) e.bindingResult).errors.get(0).defaultMessage

        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        // map()：对于流的一些中间业务操作就用此方法
        // ObjectError::getDefaultMessage：我只要流中对象的defaultMessage
        //errors.stream().map(o->o.getDefaultMessage())
        // Collectors.joining(",")：joining只对字符串生效，用其他类型会报错,把所有的得到的字符串使用逗号进行隔开并组合成一个字符串
        String messages = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

        return ResultRespose.error(ChinaExceptionEnum.PARAM_ERROR.getCode(), messages);
    }

    /**
     * 处理校验接口参数时候的异常ConstraintViolationException
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultRespose ChinaExceptionHandler(ConstraintViolationException e){
        e.printStackTrace();
        return ResultRespose.error(ChinaExceptionEnum.PARAM_ERROR.getCode(), e.getMessage());
    }
}
