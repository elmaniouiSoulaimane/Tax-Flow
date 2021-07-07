package com.example.demo.ws;


import com.example.demo.bean.Quartier;
import com.example.demo.service.QuartierService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TaxFlow/v1/quartier")
@CrossOrigin("http://localhost:4200")
public class QuartierProvided {
    @Autowired
    private QuartierService quartierService;
    @GetMapping("/ListQuartiers")
    public List<Quartier> findAll() {
        return quartierService.findAll();
    }
    @GetMapping("/RechercheQuartier/{code}")
    public Quartier findByCode(@PathVariable String code) {
        return quartierService.findByCode(code);
    }
    @PostMapping("/AjouterQuartier")
    public Result save(@RequestBody Quartier quartier) {
        return quartierService.save(quartier);
    }
    @PutMapping("/ModifierQuartier/{code}")
    public Result updateQuartier(@PathVariable String code, @RequestBody Quartier quartierMod) {
        return quartierService.updateQuartier(code, quartierMod);
    }
    @Transactional
    @DeleteMapping("/DeleteQuartier/{code}")
    public Result deleteByCode(@PathVariable String code) {
        return quartierService.deleteByCode(code);
    }
    @GetMapping("/findQuartierByVille/{code}")
    public Quartier findByRue_Ville_Code(@PathVariable String code) {
        return quartierService.findByRue_Ville_Code(code);
    }
    @GetMapping("/findQuartierByRue/{code}")
    public List<Quartier> findByRue_Code(@PathVariable String code) {
        return quartierService.findByRue_Code(code);
    }
    /*public List<Quartier> findByRue_Id(Integer code) {

        return quartierService.findByRue_Id(code);
    }*/
}
