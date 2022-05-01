package com.demo01.dao;

import com.mysql.jdbc.Driver;
import com.demo01.entity.User;
import com.demo01.util.JDBCUtil;

import java.sql.*;
import java.util.Properties;

public class userDao {
    //提供对数据库的增删改查

    public static boolean insert(int id,String name , String password) throws Exception {

        String sql = "insert into user values(?,?,?)";
        try(
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,password);
            int i = preparedStatement.executeUpdate();
            if (i >= 1){
                return true;
            }
            return false;
        }

    }

    public static User get(int id) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/users";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "15956806130wzx");

        Driver driver = new Driver();
        Connection connect = driver.connect(url, properties);
        String sql = "select name,password from user where id = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            User user = new User();
            user.setUsername(resultSet.getString(1));

            user.setPassword(resultSet.getString(2));
            return user;
        }
        return null;
    }
    public static User findUser(int id) throws Exception {
        String sql = "select id,name,password from user where id=?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}