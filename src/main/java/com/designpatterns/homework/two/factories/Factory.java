package com.designpatterns.homework.two.factories;

import com.designpatterns.homework.two.service.UserInputServiceImpl;
import com.designpatterns.homework.two.service.UserInput;

public class Factory {
    public static UserInput getUserInput() {
        //TODO Aqui va el switch cuando se haga el input por frontend
        return new UserInputServiceImpl();
    }
}
