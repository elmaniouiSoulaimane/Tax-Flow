package com.example.demo.ws;

import com.example.demo.bean.Commune;
import com.example.demo.service.CommuneService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TaxFlow/Commune")
@CrossOrigin("http://localhost:4200")
public class CommuneController {
    @Autowired
    private CommuneService communeService;
    @GetMapping("/ListCommuneByVille/{name}")
    public List<Commune> findByVille_Name(@PathVariable String name) {
        return communeService.findByVille_Name(name);
    }
    @Transactional
    @DeleteMapping("/SupprimerCommune/{name}")
    public int deleteByNomComunne(@PathVariable String name) {
        return communeService.deleteByNomComunne(name);
    }
    @GetMapping("/RechercheCommune/{name}")
    public Commune findByNomComunne(@PathVariable String name) {
        return communeService.findByNomComunne(name);
    }
    @GetMapping("/ListCommune")
    public List<Commune> findAll() {
        return communeService.findAll();
    }
    @PostMapping("/AjouterCommune")
    public Result save(@RequestBody Commune entity) {
        return communeService.save(entity);
    }
    @PutMapping("/ModifierCommune/{nom}")
    public Result ModiferCommune(@PathVariable String nom, @RequestBody Commune ModCommune) {
        return communeService.ModiferCommune(nom, ModCommune);
    }
}
