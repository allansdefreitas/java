package br.allan.library.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "br.allan.library.entity" })
@EnableJpaRepositories(basePackages = { "br.allan.library.repository" })
@ComponentScan(basePackages = {"br.allan.library.controller"})

public class Application {

	public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
      }

}