package com.designpatterns.homework.two.service.dbConection;

import com.designpatterns.homework.two.service.DbAdapter;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDBAdapter implements DbAdapter {

    private final String user;
    private final String password;
    private final String host;
    private final String port;
    private final String db;

    static {
        try {
            new com.mysql.jdbc.Driver();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error on load MySQL Driver");
        }
    }

    public MySQLDBAdapter(String user, String password, String host, String port, String db) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
        this.db = db;
    }

    @Override
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://${host}:${port}/${db}?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useUnicode=true&amp;characterEncoding=UTF-8;"
                .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("MySQL connection error " + e.getMessage());
        }
    }
}
