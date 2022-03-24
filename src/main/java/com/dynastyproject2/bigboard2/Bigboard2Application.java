package com.dynastyproject2.bigboard2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * 
 * @author Ryan Jones
 * March 23rd, 2022
 * 
 *This is the class from which the application is ran.
 */
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class,ErrorMvcAutoConfiguration.class,DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableJpaAuditing
public class Bigboard2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bigboard2Application.class, args);
	}

}
