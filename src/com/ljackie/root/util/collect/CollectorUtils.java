package com.ljackie.root.util.collect;

import java.util.Collection;

/**
 * @PackageName: com.ljackie.root.util.collect
 * @Description: //集合工具类
 * @Author: ljackie
 * @Date: 2020/3/30 10:01 上午
 */
public abstract class CollectorUtils {

    /**
     * 无参数构造
     */
    public CollectorUtils()
    {}

    public static boolean isNotEmpty(Collection<?> collection)
    {
        return collection != null || !collection.isEmpty();
    }
}
