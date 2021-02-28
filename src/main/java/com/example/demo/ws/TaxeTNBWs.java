package com.example.demo.ws;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.service.TaxeTNBService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/taxe")
public class TaxeTNBWs {
    @Autowired
    public TaxeTNBService taxeTNBService;
    @PostMapping("/")
    public Result save(@RequestBody TaxeTNB taxeTNB) {
        return taxeTNBService.save(taxeTNB);
    }

    @GetMapping("/tertain/{id}")
    public TaxeTNB findByTerrainId(@PathVariable Long id) {
        return taxeTNBService.findByTerrainId(id);
    }

    @GetMapping("/")
    public List<TaxeTNB> findAll() {
        return taxeTNBService.findAll();
    }

    @GetMapping("/terrain/ref/{ref}/annee/{annee}")
    public Terrain findByTerrainReferenceAndAnnee(@PathVariable String ref,@PathVariable Long annee) {
        return taxeTNBService.findByTerrainReferenceAndAnnee(ref, annee);
    }

}
