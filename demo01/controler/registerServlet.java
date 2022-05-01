package com.demo01.controler;

import com.demo01.core.Request;
import com.demo01.core.Response;
import com.demo01.core.Servlet;
import com.demo01.core.handResponse;
import com.demo01.dao.userDao;
import com.demo01.entity.User;

public class registerServlet implements Servlet {
    @Override
    public void service(Request request, Response response) throws Exception {
            if (request.getType().equals("POST")){
                //说明注册请求不在url里，而是在请求体里
                //处理用户登陆的请求
                String body = request.getBody();
                String[] split = body.split("&");
                String[] split1 = split[0].split("=");
                String[] split2 = split[1].split("=");
                String[] split3 = split[2].split("=");
                User user = userDao.findUser(Integer.parseInt(split3[1]));
                String name = split1[1];
                String password = split2[1];
                int id = Integer.parseInt(split3[1]);
                if (user == null){
                    //说明用户不存在可以注册

                    boolean flag = userDao.insert(id,name, password);
                    if (flag){
                        //说明注册成功了
                        handResponse.registerSuccess(response.getOutputStream());
                    }
                }else {
                    handResponse.registerFail(response.getOutputStream());
                }
            }else if (request.getType().equals("GET")){
                int id =Integer.parseInt(request.getParameters("id"));
                String name = request.getParameters("name");
                String password = request.getParameters("password");
                User user = userDao.findUser(id);
                if (user == null){
                    //说明用户不存在可以注册

                    boolean flag = userDao.insert(id,name, password);
                    if (flag){
                        //说明注册成功了
                        handResponse.registerSuccess(response.getOutputStream());
                    }
                }else {
                    handResponse.registerFail(response.getOutputStream());
                }
            }
    }

}
