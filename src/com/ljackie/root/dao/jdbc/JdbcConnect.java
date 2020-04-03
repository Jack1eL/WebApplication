package com.ljackie.root.dao.jdbc;

import com.ljackie.root.annotation.JdbcProper;
import com.ljackie.root.dao.BaseJdbcConnect;
import com.ljackie.root.util.fileresolve.IFileResources;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * @PackageName: com.ljackie.root.dao.jdbc
 * @Description: //TODO
 * @Author: ljackie
 * @Date: 2020/4/2 11:06 上午
 */
public class JdbcConnect extends BaseJdbcConnect {


    @Override
    protected Connection getConnect() throws ClassNotFoundException, SQLException {
        Class clazz = Class.forName("com.ljackie.root.dao.BaseJdbcConnect");
        Field[] fields = clazz.getDeclaredFields();
        Map jdbcInfoMap = IFileResources.map;
        for (Field field:fields)
        {
            if(field.getAnnotation(JdbcProper.class)!=null)
            {
               String value = field.getAnnotation(JdbcProper.class).value();
            }
        }
        return null;
    }

    @Override
    protected void closeConnect(Connection connection) throws SQLException {

    }
}
