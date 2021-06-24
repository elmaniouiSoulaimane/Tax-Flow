package com.example.demo;


import com.example.demo.service.PenaliteService;
import com.example.demo.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication {
    @Autowired
    private static TerrainService terrainService;
    @Autowired
    private static PenaliteService penaliteService;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
