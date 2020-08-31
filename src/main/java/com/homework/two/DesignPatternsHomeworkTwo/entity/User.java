package com.homework.two.DesignPatternsHomeworkTwo.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "car", nullable = false, length = 100)
    private String car;

    public User(){
        //TODO Required by hibernate
    }

    public User(String name, String lastName, String car) {
        this.name = name;
        this.lastName = lastName;
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Usuario {" +
            "\"id\":" +"\"" + id +"\""+
            ",\"nombre\":\"" + name + "\"" +
            ",\"apellido\":\""+ lastName + "\"" +
            ",\"auto\":\"" + car + "\"" +
            '}';
    }
}

