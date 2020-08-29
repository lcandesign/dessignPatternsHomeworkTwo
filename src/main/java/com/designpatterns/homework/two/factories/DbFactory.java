package com.designpatterns.homework.two.factories;

import com.designpatterns.homework.two.model.ConfigLoader;
import com.designpatterns.homework.two.service.DbAdapter;
import com.designpatterns.homework.two.service.dbConection.MySQLDBAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class DbFactory {

    private static EntityManagerFactory entityManagerFactory;
    private static String driver;
    private static String user;
    private static String password;
    private static String host;
    private static String port;
    private static String db;

    public static DbAdapter getDBAdapter(){
        System.out.println("Conectado a una BD => " + driver);
        switch(driver){
            case "mysql":
                return new MySQLDBAdapter(user,password,host,port,db);
            case "oracle":
                //TODO implementar
            case "sqlserver":
                //TODO implementar
            default:
                throw new RuntimeException("Unsupported db type");
        }
    }

    public static EntityManager getEntityManager() {
        driver = ConfigLoader.getDBType().toLowerCase();
        user = ConfigLoader.getProperty("MySQL.user");
        password = ConfigLoader.getProperty("MySQL.password");
        host = ConfigLoader.getProperty("MySQL.host");
        port = ConfigLoader.getProperty("MySQL.port");
        db = ConfigLoader.getProperty("MySQL.db");
        String dialect = ConfigLoader.getProperty("MySQL.dialect");

        Map<String, String> persistenceMap = new HashMap<>();
        persistenceMap.put("javax.persistence.jdbc.url","jdbc:"+driver+"://"+host+":"+port+ "/"+db);
        persistenceMap.put("javax.persistence.jdbc.user", ConfigLoader.getProperty("MySQL.user"));
        persistenceMap.put("javax.persistence.jdbc.password", ConfigLoader.getProperty("MYSQL.password"));
        persistenceMap.put("javax.persistence.jdbc.driver", ConfigLoader.getProperty("MySQL.driver"));

        persistenceMap.put("hibernate.dialect", "org.hibernate.dialect."+dialect);
        persistenceMap.put("hibernate.show_sql", "true");
        persistenceMap.put("hibernate.format_sql", "false");
        persistenceMap.put("hibernate.hbm2ddl.auto", "update");

        entityManagerFactory = Persistence.createEntityManagerFactory("homeworkTwo", persistenceMap);
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager() {
        entityManagerFactory.close();
    }
}
