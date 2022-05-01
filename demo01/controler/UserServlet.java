package com.demo01.controler;

import com.demo01.core.Request;
import com.demo01.core.Response;
import com.demo01.core.Servlet;
import com.demo01.core.handResponse;
import com.demo01.dao.userDao;
import com.demo01.entity.User;

import java.sql.SQLException;

public class UserServlet implements Servlet {
    @Override
    public void service(Request request, Response response) throws SQLException {
        int id = Integer.parseInt(request.getParameters("id"));
            User user = userDao.get(id);
            if (user != null){
                //告诉浏览器我这是一个普通文本，不是html文本了
                response.setHeader("Content-Type","text/plain;charset=UTF-8");
                response.setHeader("Content-Length",Integer.toString(user.toString().length()));
                response.setBody(user.toString());
                handResponse.write(response.getOutputStream(),response);
            }
    }
    }
