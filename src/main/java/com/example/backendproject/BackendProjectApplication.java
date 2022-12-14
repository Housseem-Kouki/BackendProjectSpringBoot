package com.example.backendproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy  //Activation de lAOP

public class BackendProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendProjectApplication.class, args);
    }

}
