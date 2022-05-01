package com.demo01.core;

import java.io.*;
import java.util.Map;

public class handResponse {

    public static String hand(Response response){
        //把一个Response对象拆成字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(response.getProtocol()).append(" ")
                     .append(response.getCode()).append(" ")
                     .append(response.getMessage()).append("\r\n");
        for (Map.Entry<String,String> entry : response.getHeaders().entrySet()){
            //拼响应头
            stringBuilder.append(entry.getKey()).append(": ")
                         .append(entry.getValue()).append("\r\n");
        }
        stringBuilder.append("\r\n");
        if (response.getBody() != null){
            stringBuilder.append(response.getBody());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Response response = new Response();
        response.setHeader("location","https://www.baidu.com");
        System.out.println(handResponse.hand(response));
    }
    public static void write(OutputStream outputStream, Response response){
        String res = hand(response);
        try {
            outputStream.write(res.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //返回客户端注册失败的响应
    public static void registerSuccess(OutputStream outputStream){
        Response response = new Response();
        String body = "<h1>注册成功</h1>";
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setHeader("Content-Length",Integer.toString(body.getBytes().length));
        response.setBody(body);
        handResponse.write(outputStream,response);
    }
    public static void loginSuccess(OutputStream outputStream){
        Response response = new Response();
        String body = "<h1>登陆成功</h1>";
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setHeader("Content-Length",Integer.toString(body.getBytes().length));
        response.setBody(body);
        handResponse.write(outputStream,response);
    }
    public static void registerFail(OutputStream outputStream){
        Response response = new Response();
        String body = "<h1>注册失败</h1>";

        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setHeader("Content-Length",Integer.toString(body.getBytes().length));
        response.setBody(body);
        handResponse.write(outputStream,response);
    }
    public static void loginFail(OutputStream outputStream){
        Response response = new Response();
        String body = "<h1>登陆失败</h1>";

        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setHeader("Content-Length",Integer.toString(body.getBytes().length));
        response.setBody(body);
        handResponse.write(outputStream,response);
    }

//    public static String readStaticFile(String filePath){
//        File file = new File(filePath);
//        StringBuilder stringBuilder = null;
//        try {
//            InputStream fileInputStream = new FileInputStream(file);
//            byte[] buf = new byte[1024];
//            int len;
//             stringBuilder = new StringBuilder();
//            while ((len = fileInputStream.read(buf)) != -1){
//                stringBuilder.append(new String(buf,0,len));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return stringBuilder.toString();
//    }
}
