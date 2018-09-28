package com.whh.handler;

/**
 * @ProjectName: test_demo
 * @Author: swang
 * @Date: 2018/9/28 15:57
 * @Description:
 */
public class ParamException extends RuntimeException {
    private static final long serialVersionUID = -2189864542822167173L;

    public ParamException(){
        super();
    }

    public ParamException(String message){
        super(message);
    }
}