package com.example.demo.ws;

import com.example.demo.bean.Exoneration;
import com.example.demo.service.ExonerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("taxe-tnb/exoneration")
public class ExonerationWs {
    @Autowired
    public ExonerationService exonerationService;

    @GetMapping("/")
    List<Exoneration> findAll(){
        return exonerationService.findAll();
    }

    @GetMapping("/annee/{annee}")
    public Exoneration findByTaxeTNBAnnee(Year annee){
        return exonerationService.findByTaxeTNBAnnee(annee);
    }

    @GetMapping("/reference-terrain/{reference}")
    public Exoneration findByTaxeTNB_Terrain_Reference(String reference){
        return exonerationService.findByTaxeTNB_Terrain_Reference(reference);
    }

    @DeleteMapping("/annee-taxeTNB/{annee}")
    public Integer deleteByTaxeTNBAnnee(Year annee){
        return exonerationService.deleteByTaxeTNBAnnee(annee);
    }

    @PutMapping("exoneration/{id}")
    public Exoneration update(Exoneration nouveauExoneration, Long id){
        return exonerationService.update(nouveauExoneration,id);
    }


}
