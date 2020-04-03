package com.ljackie.root.annotation;

import java.lang.annotation.*;

/**
 * @PackageName: com.ljackie.root.annotation
 * @Description: //annotation to get instance
 * @Author: ljackie
 * @Date: 2020/4/1 10:42 上午
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowrite {
    String value() default "";
}
