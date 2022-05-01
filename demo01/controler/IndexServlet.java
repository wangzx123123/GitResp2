package com.demo01.controler;

import com.demo01.constant.constant;
import com.demo01.core.Request;
import com.demo01.core.Response;
import com.demo01.core.Servlet;
import com.demo01.core.handResponse;
import com.demo01.util.ioUtil;

public class IndexServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        String path = constant.ROOT_DIR+request.getUrl();
        String file = ioUtil.getFile(path);
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setHeader("Content-Length",Integer.toString(file.length()));
        response.setBody(file);
        handResponse.write(response.getOutputStream(),response);
   }
}
