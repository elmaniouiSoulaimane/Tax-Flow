package com.example.demo.ws;

import com.example.demo.bean.Taux;
import com.example.demo.service.TauxService;
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
    @GetMapping("/RechercheTauxByCategorieID/{id}")
    public Taux findByCategoryId(@PathVariable Long id) {
        return tauxService.findByCategoryId(id);
    }
    @GetMapping("/ListDesTaux")
    public List<Taux> findAll() {
        return tauxService.findAll();
    }
    @PostMapping("/AjouterTaux")
    public int save(@RequestBody Taux taux) {
        return tauxService.save(taux);
    }
    @Transactional
    @DeleteMapping("SupprimerTauxByCategorieNom/{libelle}")
    public Integer deleteByCategory_Libelle(@PathVariable String libelle){
        return tauxService.deleteByCategory_Libelle(libelle);
    }
    @PutMapping("ModifierTaux/{id}")
    public Taux update(@RequestBody Taux nouveauTaux,@PathVariable Long id){
        return tauxService.update(nouveauTaux,id);
    }
    @GetMapping("/RechercheById/{id}")
    public Taux findTauxById(@PathVariable Long id) {
        return tauxService.findTauxById(id);
    }
}
