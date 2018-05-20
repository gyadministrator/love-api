package com.gy.love.loveapi.annotation;


import java.lang.annotation.*;

/**
 * 当前登陆对象
 * on 2017/5/11.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
