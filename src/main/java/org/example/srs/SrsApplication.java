package org.example.srs;

import org.example.srs.Util.GerenciadorData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class SrsApplication {
    public static void main(String[] args) {
        
        SpringApplication.run(SrsApplication.class, args);
    }
}
