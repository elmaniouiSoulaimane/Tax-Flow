package com.example.demo.ws;

import com.example.demo.bean.Penalite;
import com.example.demo.service.PenaliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("taxe-tnb/penalite")
public class PenaliteWs {
    @Autowired
    public PenaliteService penaliteService;

    @GetMapping("/")
    public List<Penalite> findAll(){
        return penaliteService.findAll();
    }

    @GetMapping("penalite/{annee}")
    public Penalite findfindByTaxeTNBAnnee(Date annee){
        return penaliteService.findfindByTaxeTNBAnnee(annee);
    }

    @GetMapping("penalite/reference")
    public Penalite findByTaxeTNBTerrainReference(String reference){
        return penaliteService.findByTaxeTNBTerrainReference(reference);
    }

    @DeleteMapping("/annee/annee")
    public Integer deleteByTaxeTNBAnnee(Year annee){
        return penaliteService.deleteByTaxeTNBAnnee(annee);
    }

    @PostMapping("/")
    public Integer save(Penalite penlaite){
        return penaliteService.save(penlaite);
    }

    @PutMapping("penalite/{id}")
    public Penalite update(@RequestBody Penalite nouveauPenalite,@PathVariable Long id){
        return penaliteService.update(nouveauPenalite,id);
    }
}
