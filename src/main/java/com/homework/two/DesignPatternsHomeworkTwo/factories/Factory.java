package com.homework.two.DesignPatternsHomeworkTwo.factories;

import com.homework.two.DesignPatternsHomeworkTwo.service.UserInput;
import com.homework.two.DesignPatternsHomeworkTwo.service.UserInputServiceImpl;

public class Factory {
    public static UserInput getUserInput() {
        //TODO Aqui va el switch cuando se haga el input por frontend
        return new UserInputServiceImpl();
    }
}
