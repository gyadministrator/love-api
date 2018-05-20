package com.gy.love.loveapi.exception;

public class ArgumentsException extends RuntimeException {

    public ArgumentsException(String message) {
        super("参数错误:" + message);
    }
}
