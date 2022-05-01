package com.demo01.core;

public interface Servlet {
    //定义一个接口,具体怎么实现让下面的servlet去实现
    void service(Request request,Response response) throws Exception;
}
