package com.demo01.core;

import com.demo01.controler.IndexServlet;
import com.demo01.controler.LoginServlet;
import com.demo01.controler.UserServlet;
import com.demo01.controler.registerServlet;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Container {
    //通过容器，取出一个个的servlet


    private static final Map<String, Servlet> SERVLETS = new ConcurrentHashMap<>(8);
//    static {
//        Properties properties = new Properties();
//        try {
//            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("src/com/demo01/core/servlet.properties"));
//            System.out.println(properties);
//            //配置文件信息已经读到了properties里了
//            Set<Map.Entry<Object, Object>> entries = properties.entrySet();
//
//            for (Map.Entry entry : entries){
//                Servlet servlet = (Servlet)Class.forName((String)entry.getValue()).newInstance();
//                SERVLETS.put((String) entry.getKey(), servlet);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static  Servlet get(String URL){
//        //多态
//
//        Servlet servlet = SERVLETS.get(URL);
//        System.out.println(servlet);
//        if (servlet != null){
//            return servlet;
//
//        }
//        return null;
//    }









    static {
        //
        SERVLETS.put("/user",new UserServlet());
        SERVLETS.put("/register",new registerServlet());
        SERVLETS.put("/index",new IndexServlet());
        SERVLETS.put("/login",new LoginServlet());
    }
    public static  Servlet get(String URL){
        //多态
        Servlet servlet = SERVLETS.get(URL);
        if (servlet != null){
            return servlet;
        }
        return null;
    }
}
