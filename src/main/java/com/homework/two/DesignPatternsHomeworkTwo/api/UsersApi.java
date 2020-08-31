package com.homework.two.DesignPatternsHomeworkTwo.api;

import com.homework.two.DesignPatternsHomeworkTwo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersApi {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getById() {
        return new User("John", "Doe", "+57 311 222 3344");
    }
}
