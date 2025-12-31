package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
    String password = "admin123456789"; 
    String s = null;
    System.out.println(s.length());
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
    }
}
