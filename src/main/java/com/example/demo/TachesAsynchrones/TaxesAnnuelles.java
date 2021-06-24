package com.example.demo.TachesAsynchrones;

import com.example.demo.bean.Terrain;
import com.example.demo.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class TaxesAnnuelles extends TimerTask {
    @Autowired
    private static TerrainService terrainService;
    public void run(){
        LocalDate date = LocalDate.now();
        List<Terrain> allTerrain;
        allTerrain = terrainService.findAll();
        for (Terrain terrain : allTerrain) {
            if (terrain.getTaxeTNB().getAnnee() != date.getYear()) {
                if (date.getMonth() == Month.JANUARY) {
                    terrain.setTaxeTNB();
                }
            }
        }
    }

    public static void main(String[] args){
        LocalDateTime uneAnneeApres = LocalDateTime.now().plusYears(1);
        Date uneAnneeApresCommeDate = Date.from(uneAnneeApres.atZone(ZoneId.systemDefault()).toInstant());
        int period =31556952 * 1000;
        new Timer().schedule(new TaxesAnnuelles(), uneAnneeApresCommeDate, period);
    }
}
