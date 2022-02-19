package com.example.easymeals;

import com.example.easymeals.dataprovider.SpoonacularDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasymealsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasymealsApplication.class, args);
    }

}
