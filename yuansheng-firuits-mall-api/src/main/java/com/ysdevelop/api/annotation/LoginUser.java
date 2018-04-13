package com.ysdevelop.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @author OldHuang
 *
 * @Package com.ysdevelop.api.annotation
 *
 * @Description: 用户登录注解
 *
 * @date 2018年4月13日
 * 
 * @version 
 *
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {

}
