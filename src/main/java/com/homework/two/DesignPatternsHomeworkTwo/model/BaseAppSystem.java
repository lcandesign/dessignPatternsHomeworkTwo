package com.homework.two.DesignPatternsHomeworkTwo.model;

import com.homework.two.DesignPatternsHomeworkTwo.entity.User;
import com.homework.two.DesignPatternsHomeworkTwo.factories.DbFactory;
import com.homework.two.DesignPatternsHomeworkTwo.factories.Factory;
import com.homework.two.DesignPatternsHomeworkTwo.repository.UserRepository;
import com.homework.two.DesignPatternsHomeworkTwo.service.DbAdapter;
import com.homework.two.DesignPatternsHomeworkTwo.service.UserInput;
import com.homework.two.DesignPatternsHomeworkTwo.service.UserInputServiceImpl;

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
