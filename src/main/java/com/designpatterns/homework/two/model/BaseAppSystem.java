package com.designpatterns.homework.two.model;

import com.designpatterns.homework.two.factories.DbFactory;
import com.designpatterns.homework.two.factories.Factory;
import com.designpatterns.homework.two.service.DbAdapter;
import com.designpatterns.homework.two.service.UserInputServiceImpl;
import com.designpatterns.homework.two.service.UserInput;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseAppSystem {
    public void run() throws SQLException {
        UserInput userInput = Factory.getUserInput();
        UserInputServiceImpl userInputServiceImplRequest = userInput.getUserInput();
        DbAdapter adapter = DbFactory.getDBAdapter();
        Connection connection = adapter.getConnection();
        System.out.println("Conexión abierta => " + (!connection.isClosed()));
        //TODO Aquí va el guardado del usuario.
        System.out.println(userInputServiceImplRequest.getName());
        System.out.println(userInputServiceImplRequest.getLastName());
        System.out.println(userInputServiceImplRequest.getCar());
    }
}
