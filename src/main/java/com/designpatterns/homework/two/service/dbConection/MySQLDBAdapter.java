package com.designpatterns.homework.two.service.dbConection;

import com.designpatterns.homework.two.model.ConfigLoader;
import com.designpatterns.homework.two.service.DbAdapter;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDBAdapter implements DbAdapter {

    static {
        try {
            new com.mysql.jdbc.Driver();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error on load MySQL Driver");
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String user = ConfigLoader.getProperty("MySQL.user");
            String password = ConfigLoader.getProperty("MySQL.password");
            String host = ConfigLoader.getProperty("MySQL.host");
            String port = ConfigLoader.getProperty("MySQL.port");
            String db = ConfigLoader.getProperty("MySQL.db");

            String url = "jdbc:mysql://${host}:${port}/${db}?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useUnicode=true&amp;characterEncoding=UTF-8;"
                .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("MySQL connection error " + e.getMessage());
        }
    }
}
