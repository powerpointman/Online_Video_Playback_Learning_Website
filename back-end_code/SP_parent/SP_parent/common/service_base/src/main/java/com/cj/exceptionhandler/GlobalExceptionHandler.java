package com.cj.exceptionhandler;

import com.cj.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody//能够返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行全局异常处理");
    }
    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//能够返回数据
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行ArithmeticException异常处理");
    }
    //自定义异常
    @ExceptionHandler(PJException.class)
    @ResponseBody//能够返回数据
    public R error(PJException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }


}
