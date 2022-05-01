package com.demo01.controler;

import com.demo01.core.Request;
import com.demo01.core.Response;
import com.demo01.core.Servlet;
import com.demo01.core.handResponse;
import com.demo01.dao.userDao;
import com.demo01.entity.User;

public class LoginServlet implements Servlet {

    @Override
    public void service(Request request, Response response) throws Exception {
        String type = request.getType();
        if ("POST".equals(type)){
            String body = request.getBody();
            String[] split = body.split("&");
            String[] s1 = split[0].split("=");
            String[] s2 = split[1].split("=");
            String[] s3 = split[2].split("=");
            String name = s1[1];
            String password = s2[1];
            String id = s3[1];
            User user = userDao.findUser(Integer.parseInt(id));
            if (user == null){
                handResponse.loginFail(response.getOutputStream());
            }else {
                if (password.equals(user.getPassword())){
                    handResponse.loginSuccess(response.getOutputStream());
                }else {
                    handResponse.loginFail(response.getOutputStream());
                }
            }

        }
    }
}
