package com.magic.springboot.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Magicfeng007
 * @Description: 全局异常处理器
 * @Date: Created in 2018-06-11---下午8:58
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
//    @ResponseBody   //类使用ControllerAdvice标注时需要加上@ResponseBody
    public String globalExceptionHander(HttpServletRequest request,Exception e){
        return  "对不起，服务器挂了，请不要太用力哦";
    }
}
