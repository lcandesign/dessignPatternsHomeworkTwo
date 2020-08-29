package com.designpatterns.homework.two.model;

import com.designpatterns.homework.two.factories.DbFactory;
import com.designpatterns.homework.two.factories.Factory;
import com.designpatterns.homework.two.model.entity.User;
import com.designpatterns.homework.two.model.repository.UserRepository;
import com.designpatterns.homework.two.service.DbAdapter;
import com.designpatterns.homework.two.service.UserInputServiceImpl;
import com.designpatterns.homework.two.service.UserInput;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class BaseAppSystem {
    public void run() throws SQLException {
        UserInput userInput = Factory.getUserInput();
        UserInputServiceImpl userInputService = userInput.getUserInput();

        EntityManager entityManager = DbFactory.getEntityManager();
        DbAdapter adapter = DbFactory.getDBAdapter();
        Connection connection = adapter.getConnection();
        System.out.println("Conexión abierta => " + (!connection.isClosed()));

        System.out.println("Guardando usuario");
        User user = new User(userInputService.getName(),userInputService.getLastName(),userInputService.getCar());
        UserRepository userRepository = new UserRepository(entityManager);
        Optional<User> savedUser = userRepository.save(user);
        System.out.println("Usuario guardado: " + (savedUser.map(User::toString).orElse(null)));

        entityManager.close();
        DbFactory.closeEntityManager();

    }
}
