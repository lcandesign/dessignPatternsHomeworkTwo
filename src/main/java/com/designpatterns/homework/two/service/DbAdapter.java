package com.designpatterns.homework.two.service;

import java.sql.Connection;

public interface DbAdapter {
    public Connection getConnection();
}
