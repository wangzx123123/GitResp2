package com.demo01;

import com.demo01.constant.constant;
import com.demo01.core.*;
import com.demo01.util.ioUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class myServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务监听在8888端口");
        while (true){
            Socket accept = serverSocket.accept();
            //连接发过来
            OutputStream outputStream = accept.getOutputStream();
            InputStream inputStream = accept.getInputStream();

            //看看你的请求
            Request request = handRequest.hand(inputStream);
            Response response = new Response();
            response.setOutputStream(outputStream);

            String url = request.getUrl();
            if (url.contains(".html")){
                //请求的是静态资源
                String path = constant.ROOT_DIR+request.getUrl();
                String body = ioUtil.getFile(path);
                if (body != null){
                    response.setHeader("Content-Type","text/html;charset=UTF-8");
                    response.setHeader("Content-Length",Integer.toString(body.length()));
                    response.setBody(body);
                    handResponse.write(response.getOutputStream(),response);
                }

            }else {
                //根据请求的url，给浏览器回不同的response
                //根据url得到servlet,这是动态获取资源
                Servlet servlet = Container.get(url);
                System.out.println(servlet);
                if (servlet != null){
                    servlet.service(request,response);
                }

            }
            //业务逻辑就是我服务器读到一个浏览器发来的请求，



            inputStream.close();
            outputStream.close();
        }
    }
}
