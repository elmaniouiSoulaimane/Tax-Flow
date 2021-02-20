package com.example.demo.ws;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.service.TaxeTNBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/taxe")
public class TaxeTNBWs {

    @PostMapping("/")
    public Integer save(@RequestBody TaxeTNB taxeTNB) {
        return taxeTNBService.save(taxeTNB);
    }
   /* @GetMapping("/")
    public TaxeTNB findByReference(@PathVariable String reference) {
        return taxeTNBService.findByReference(reference);
    }
    @DeleteMapping("/")
    public Integer deleteByReference(String reference) {
        return taxeTNBService.deleteByReference(reference);
    }*/
    @GetMapping("/")
    public List<TaxeTNB> findAll() {
        return taxeTNBService.findAll();
    }

    @GetMapping("/terrain/ref/{ref}/annee/{annee}")
    public Terrain findByTerrainReferenceAndAnnee(@PathVariable String ref,@PathVariable Long annee) {
        return taxeTNBService.findByTerrainReferenceAndAnnee(ref, annee);
    }

    @Autowired
    public TaxeTNBService taxeTNBService;
}
