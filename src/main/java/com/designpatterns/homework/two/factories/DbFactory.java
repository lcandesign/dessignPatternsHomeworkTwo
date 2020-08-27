package com.designpatterns.homework.two.factories;

import com.designpatterns.homework.two.model.ConfigLoader;
import com.designpatterns.homework.two.service.DbAdapter;
import com.designpatterns.homework.two.service.dbConection.MySQLDBAdapter;

public class DbFactory {
    public static DbAdapter getDBAdapter(){
        String dbType = ConfigLoader.getDBType();
        System.out.println("Conectado a una BD => " + dbType);
        switch(dbType){
            case "MySQL":
                return new MySQLDBAdapter();
            case "Oracle":
                //TODO implementar
            case "SQLServer":
                //TODO implementar
            default:
                throw new RuntimeException("Unsupported db type");
        }
    }
}
