package com.ljackie.root.annotation;

import java.lang.annotation.*;

/**
 * @PackageName: com.ljackie.root.annotation
 * @Description: //TODO
 * @Author: ljackie
 * @Date: 2020/4/1 5:35 下午
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JdbcProper {
    String value();
}
