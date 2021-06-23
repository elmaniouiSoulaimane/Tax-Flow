package com.example.demo.TachesAsynchrones;


import com.example.demo.bean.Terrain;
import com.example.demo.service.PenaliteService;
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
public class PenaliteMensuelle extends TimerTask {
    @Autowired
    private TerrainService terrainService;
    @Autowired
    private PenaliteService penaliteService;
    public void run(){
        LocalDate date = LocalDate.now();
        List<Terrain> allTerrain;
        allTerrain = terrainService.findAll();
        for (Terrain terrain : allTerrain) {
            if (date.getMonth() == Month.MARCH) {
                if (terrain.getTaxeTNB().getPenalite() != null && !terrain.getTaxeTNB().isStatusPaiement()) {
                    penaliteService.update(terrain.getTaxeTNB().getPenalite(), terrain.getTaxeTNB().getPenalite().getId());
                }
            }
        }
    }

    public static void main(String[] args){
        LocalDateTime unMoisApres = LocalDateTime.now().plusMonths(1);
        Date unMoisApresCommeDate = Date.from(unMoisApres.atZone(ZoneId.systemDefault()).toInstant());
        int period =2592* 1000000;
        new Timer().schedule(new PenaliteMensuelle(), unMoisApresCommeDate, period);
    }
}
