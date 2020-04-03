package com.ljackie.root.dao;

import com.ljackie.root.annotation.JdbcProper;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @PackageName: com.ljackie.root.dao
 * @Description: //TODO
 * @Author: ljackie
 * @Date: 2020/4/2 11:03 上午
 */
public abstract class BaseJdbcConnect {

    @JdbcProper(value = "jdbc-driver-class-name")
    private String driverName;
    @JdbcProper(value = "jdbc-url")
    private String url;
    @JdbcProper(value = "jdbc-username")
    private String username;
    @JdbcProper(value = "jdbc-password")
    private String password;

    /**
     * 获取sql连接
     * @return
     */
    protected abstract Connection getConnect() throws ClassNotFoundException, SQLException;

    /**
     * 关闭连接
     * @param connection
     */
    protected abstract void closeConnect(Connection connection) throws SQLException;
}
