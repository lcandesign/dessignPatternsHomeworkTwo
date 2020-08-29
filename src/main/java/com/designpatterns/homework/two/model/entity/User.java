package com.designpatterns.homework.two.model.entity;

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

    @Column(name = "name", unique = false, nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", unique = false, nullable = false, length = 100)
    private String lastName;

    @Column(name = "car", unique = false, nullable = false, length = 100)
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

    @Override
    public String toString() {
        return "Usuario {" +
            "id=" + id +
            ", nombre='" + name + '\'' +
            ", apellido=" + lastName +
            ", auto='" + car + '\'' +
            '}';
    }
}
