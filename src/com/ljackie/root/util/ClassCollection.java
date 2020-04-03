package com.ljackie.root.util;

/**
 * @PackageName: com.ljackie.root.util
 * @Description: //启动加载类
 * @Author: ljackie
 * @Date: 2020/4/1 6:13 下午
 */
public class ClassCollection extends BaseClassCollection {

    private static class Inner
    {
        private static BaseClassCollection baseClassCollection = new ClassCollection();
    }

    public static BaseClassCollection init()
    {
        return Inner.baseClassCollection;
    }
}
