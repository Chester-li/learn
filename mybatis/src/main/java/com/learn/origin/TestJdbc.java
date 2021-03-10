package com.learn.origin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author chaoshuai.li
 * @date 2021/3/9
 * @description
 */
public class TestJdbc {

    /**
     * 传统JDBC 使用方式
     */
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/enterprise_db";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from employee where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, 1l);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getInt("sex"));
            }
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception throwable) {
                throwable.printStackTrace();
            }

        }
    }

}
