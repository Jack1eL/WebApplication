package com.ljackie.root.util.fileresolve.factory;

import com.ljackie.root.annotation.Autowrite;
import com.ljackie.root.util.collect.StringUtils;
import java.lang.reflect.Field;


/**
 * @PackageName: com.ljackie.root.util.fileresolve.impl
 * @Description: fileresources-resolve instance factory
 * @Author: ljackie
 * @Date: 2020/3/31 11:42 上午
 */
public class IFileResourcesFactory {

    private static String modelPack = "com.ljackie.root.util.fileresolve.impl";

    public IFileResourcesFactory()
    {}

    public static Object getFileResourcesInstance(Class<?> clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields)
        {
            if(field.getAnnotation(Autowrite.class)!=null)
            {//if this field contain autowrite annotation
                String className = StringUtils.initialToUp(field.getAnnotation(Autowrite.class).value());
                Object t = Class.forName(modelPack+"."+className).newInstance();
                return t;
            }
        }
        return null;
    }

}
