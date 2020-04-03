package com.ljackie.root.util.collect;



/**
 * @PackageName: com.ljackie.root.util.collect
 * @Description: //TODO
 * @Author: ljackie
 * @Date: 2020/3/31 3:50 下午
 */
public abstract class StringUtils {

    public StringUtils()
    {}

    public static boolean isNotEmpty(String s)
    {
        return s!=null && !s.isEmpty();
    }

    public static String initialToUp(String str)
    {
        if(isNotEmpty(str))
        {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return null;
    }
}
