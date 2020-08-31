package com.homework.two.DesignPatternsHomeworkTwo.service;

import java.sql.Connection;

public interface DbAdapter {
    public Connection getConnection();
}
