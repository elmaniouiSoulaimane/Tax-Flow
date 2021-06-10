package com.example.demo.ws;

import com.example.demo.bean.Taux;
import com.example.demo.service.TauxService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/taux")
@CrossOrigin("http://localhost:4200")
public class TauxWs {
    @Autowired
    private TauxService tauxService;
    @GetMapping("/RechercheById/{id}")
    public Taux findByID(@PathVariable Long id) {
        return tauxService.findByID(id);
    }

    @GetMapping("/RechercheTauxCategorie/{id}")
    public Taux findByCategoryId(@PathVariable Long id) {
        return tauxService.findByCategoryId(id);
    }
    @GetMapping("/ListTaux")
    public List<Taux> findAll() {
        return tauxService.findAll();
    }
    @PostMapping("/AjouterTaux")
    public Result save(@RequestBody Taux taux) {
        return tauxService.save(taux);
    }
    @PutMapping("/ModifierTaux/{id}")
    public Result updateTaux(@PathVariable Long id, @RequestBody Taux tauxMod) {
        return tauxService.updateTaux(id, tauxMod);
    }
    @Transactional
    @DeleteMapping("/deleteTaux/{id}")
    public Result deleteTaux(@PathVariable Long id) {
        return tauxService.deleteTaux(id);
    }
}
