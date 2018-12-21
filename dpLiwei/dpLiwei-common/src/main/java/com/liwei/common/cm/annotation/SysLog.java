package com.liwei.common.cm.annotation;

import java.lang.annotation.*;

/**
 *
 * 系统日志注解
 *
 *@file common.annotation
 *@author liwei
 *@Date：下午7:47 下午7:47
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";


}
