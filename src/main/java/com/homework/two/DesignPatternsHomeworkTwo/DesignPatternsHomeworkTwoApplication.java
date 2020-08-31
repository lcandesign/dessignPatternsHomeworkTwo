package com.homework.two.DesignPatternsHomeworkTwo;

import com.homework.two.DesignPatternsHomeworkTwo.model.BaseAppSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DesignPatternsHomeworkTwoApplication {

	public static void main(String[] args) throws Exception {
		new BaseAppSystem().run();
		//SpringApplication.run(DesignPatternsHomeworkTwoApplication.class, args);
	}

}
