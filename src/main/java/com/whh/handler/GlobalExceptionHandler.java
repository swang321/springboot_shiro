package com.whh.handler;

import com.whh.base.common.ServerResponse;
import com.whh.base.common.enums.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: test_demo
 * @Author: swang
 * @Date: 2018/9/28 15:55
 * @Description:
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 声明异常处理方法，传递哪一个异常对象的class，就代表该方法会拦截哪一个异常对象包括其子类
     *
     * @param e e
     * @return ServerResponse
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ServerResponse exceptionHandle(Exception e, HttpServletRequest request) {
        String url = request.getRequestURL().toString();

        if (e instanceof ParamException || e instanceof DefaultCustomException) {
            log.error("[全局异常处理] url : {}, msg : {}", url, e.getMessage());

            // 如果是自定义异常的话，则返回异常消息
            String msg = StringUtils.isBlank(e.getMessage()) ? ResponseEnum.UNKONW_ERROR.getMsg() : e.getMessage();
            return ServerResponse.createByErrorMsg(msg);
        }

        log.error("[系统异常] url : {}", url, e);
        return ServerResponse.createByErrorCodeMsg(ResponseEnum.UNKONW_ERROR);
    }

}
