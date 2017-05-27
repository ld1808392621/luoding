package com.luoding.mysql;

import java.beans.Statement;
import java.sql.*;

/**
 * author: ding.luo
 * time: 17-2-21 下午10:19
 */
public class MysqlTest {

    public static void main(String [] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.14.220:3306/fraud");
        PreparedStatement statement =  connection.prepareStatement("select * from BlackList limit 1");
        ResultSet resultSet = statement.executeQuery();

    }
}
