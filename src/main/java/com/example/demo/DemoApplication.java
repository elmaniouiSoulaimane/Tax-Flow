package com.example.demo;

import com.example.demo.bean.Penalite;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.service.PenaliteService;
import com.example.demo.service.TaxeTNBService;
import com.example.demo.service.TerrainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    private static TerrainService terrainService;
    private static TaxeTNBService taxeTNBService;
    private static PenaliteService penaliteService;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        LocalDate date = LocalDate.now();
        List<Terrain> allTerrain;
        allTerrain = terrainService.findAll();
        for (Terrain terrain : allTerrain) {
            if (terrain.getTaxeTNB().getAnnee() != date.getYear()) {
                if (date.getMonth() == Month.JANUARY) {
                    terrain.setTaxeTNB();
                }else if (date.getMonth() == Month.MARCH) {
                    if (terrain.getTaxeTNB().getPenalite() != null && !terrain.getTaxeTNB().isStatusPaiement()) {
                        penaliteService.update(terrain.getTaxeTNB().getPenalite(), terrain.getTaxeTNB().getPenalite().getId());
                    }
                }
            }
        }
    }
}
