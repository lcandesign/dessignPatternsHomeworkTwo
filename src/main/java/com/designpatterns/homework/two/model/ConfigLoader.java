package com.designpatterns.homework.two.model;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties props;

    static {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("dbConfig.properties");
            ConfigLoader.props = new Properties();
            props.load(stream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration");
        }
    }

    public static String getDBType(){
        return props.getProperty("dbType");
    }

    public static String getProperty(String propName){
        return props.getProperty(propName);
    }
}
