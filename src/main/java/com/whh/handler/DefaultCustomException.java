package com.whh.handler;

/**
 * @ProjectName: test_demo
 * @Author: swang
 * @Date: 2018/9/28 15:57
 * @Description:
 */
public class DefaultCustomException extends RuntimeException {
    private static final long serialVersionUID = -6556713140329100258L;

    public DefaultCustomException() {
        super();
    }

    public DefaultCustomException(String message) {
        super(message);
    }
}