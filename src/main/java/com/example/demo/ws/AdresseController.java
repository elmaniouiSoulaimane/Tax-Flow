package com.example.demo.ws;

import com.example.demo.bean.Adresse;
import com.example.demo.service.AdresseService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TaxFlow/V1/Adresse")
@CrossOrigin("http://localhost:4200")
public class AdresseController {
    @Autowired
    private AdresseService adresseService;
    @GetMapping("/ListAdresses")
    public List<Adresse> findAll() {
        return adresseService.findAll();
    }
    /*@PostMapping("/AjouterAdresse")
    public Result save(@RequestBody Adresse adresse) {
        return adresseService.save(adresse);
    }
    @PutMapping("/ModifierAdresse/{ref}")
    public Result updateAdresse(@PathVariable String ref, @RequestBody Adresse adresseMod) {
        return adresseService.updateAdresse(ref, adresseMod);
    }*/
   /* @Transactional
    @DeleteMapping("/SupprimerAdresse/{ref}")
    public Result deleteByAdresseRef(@PathVariable String ref) {
        return adresseService.deleteByAdresseRef(ref);
    }*/
    /*@GetMapping("/RechercheAdresse/{ref}")
    public Adresse findByRef(@PathVariable String ref) {
        return adresseService.findByRef(ref);
    }*/
    @GetMapping("/findAdresseByQuartier/{id}")
    public List<Adresse> findByQuartier_Id(@PathVariable Long id) {
        return adresseService.findByQuartier_Id(id);
    }
    @GetMapping("/RechercheAdresseById/{id}")
    public Adresse findByID(@PathVariable Long id) {
        return adresseService.findByID(id);
    }
    @PutMapping("/ModifierAdresse/{id}")
    public Result updateAdresse(@PathVariable Long id, @RequestBody Adresse adresseMod) {
        return adresseService.updateAdresse(id, adresseMod);
    }
    @GetMapping("/RechercheAdresseByQuartierAndNum/{id}/{num}")
    public Adresse findByQuartierIdAndNumLot(@PathVariable Long id,@PathVariable String num) {
        return adresseService.findByQuartierIdAndNumLot(id, num);
    }
    @PostMapping("/AjouterAdresse")
    public Result save(@RequestBody Adresse adresse) {
        return adresseService.save(adresse);
    }
    @GetMapping("RechercheAdresseByQuartierID/{id}")
    public Adresse findByQuartierId(@PathVariable Long id) {
        return adresseService.findByQuartierId(id);
    }
    @Transactional
    @DeleteMapping("SupprimerAdresseByQuartierAndNum/{id}/{num}")
    public Result deleteByQuartierIdAndNumLot(@PathVariable Long id, @PathVariable String num) {
        return adresseService.deleteByQuartierIdAndNumLot(id, num);
    }
}
