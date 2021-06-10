package com.example.demo.ws;

import com.example.demo.bean.Ville;
import com.example.demo.service.VilleService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("TaxFlow/V1/Ville")
@CrossOrigin("http://localhost:4200")
public class VilleProvided {
    @Autowired
    private VilleService villeService;
    @GetMapping("/ListVilles")
    public List<Ville> findAll() {
        return villeService.findAll();
    }

    @GetMapping("/RechercheVilleByCode/{code}")
    public Ville findByCode(@PathVariable String code) {
        return villeService.findByCode(code);
    }
    @Transactional
    @DeleteMapping("/SupprimerVille/{code}")
    public Result deleteByCode(@PathVariable String code) {
        return villeService.deleteByCode(code);
    }

    @PostMapping("/AjouterVille")
    public Result save(@RequestBody Ville ville) {
        return villeService.save(ville);
    }
    @PutMapping("/ModifierVille/{code}")
    public Result updateVille(@PathVariable String code, @RequestBody Ville villeMod) {
        return villeService.updateVille(code, villeMod);
    }
}
