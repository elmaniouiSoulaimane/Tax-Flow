package com.example.demo;


import com.example.demo.service.TaxeTNBService;
import com.example.demo.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    private TerrainService terrainService;
    @Autowired
    private TaxeTNBService taxeTNBService;
    public static DemoApplication demoApplication;
    static LocalDate date = LocalDate.now();
    @PostConstruct
    public void init(){
        demoApplication = this;
        demoApplication.terrainService = this.terrainService;
        demoApplication.taxeTNBService = this.taxeTNBService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        if(date.getMonth()== Month.JULY && date.getDayOfMonth() == 3){
            demoApplication.terrainService.ajouterTaxesAnnees();
        }
        if(date.getMonth()== Month.JULY && date.getDayOfMonth() == 3){
            demoApplication.taxeTNBService.ajouterPenalites();
        }
    }
}
