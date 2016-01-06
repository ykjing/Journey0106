package com.example.yu.journey0106;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Yu on 2016/1/6.
 */
public class DBMAnager {
    Connection connection = null;
    String userName = "journey";
    String passWord = "journey";

    public DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://140.112.107.30:3306/journey", userName, passWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
