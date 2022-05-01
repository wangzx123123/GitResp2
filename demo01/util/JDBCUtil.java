package com.demo01.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    public static Connection getConnection() throws Exception{
        //这里就是直接和数据库交互的那一层,返回与数据库的连接

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/demo01/jdbc.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        if (connection != null){
            return connection;
        }
       return  null;
    }
}
