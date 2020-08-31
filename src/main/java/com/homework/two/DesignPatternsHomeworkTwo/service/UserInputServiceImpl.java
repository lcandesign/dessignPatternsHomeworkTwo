package com.homework.two.DesignPatternsHomeworkTwo.service;

import java.util.Scanner;

public class UserInputServiceImpl  implements UserInput {
    private String name;
    private String lastName;
    private String car;

    public UserInputServiceImpl() {}

    public UserInputServiceImpl(String name, String lastName, String car) {
        this.name = name;
        this.lastName = lastName;
        this.car = car;
    }

    public UserInputServiceImpl getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre del usuario: ");
        String name = scan.nextLine();
        System.out.print("Introduce el apellido del usuario: ");
        String lastName = scan.nextLine();
        System.out.print("Introduce el modelo de auto seleccionado: ");
        String car = scan.nextLine();
        return new UserInputServiceImpl(name, lastName, car);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
