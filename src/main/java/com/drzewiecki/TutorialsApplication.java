package com.drzewiecki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"com.drzewiecki"} ) //Scans entities outside bank package
public class TutorialsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorialsApplication.class, args);
    }
}
