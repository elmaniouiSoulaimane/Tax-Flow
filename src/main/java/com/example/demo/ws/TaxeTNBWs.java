package com.example.demo.ws;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.service.TaxeTNBService;
import com.example.demo.service.util.Result;
import com.example.demo.vo.TaxeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("boisson/taxe")
public class TaxeTNBWs {
    @Autowired
    public TaxeTNBService taxeTNBService;

    @PostMapping("/")
    public void save(@RequestBody TaxeTNB taxeTNB) {
        taxeTNBService.save(taxeTNB);
    }

    @GetMapping("/")
    public List<TaxeTNB> findAll() {
        return taxeTNBService.findAll();
    }

    @PostMapping("/criterea")
    public List<TaxeTNB> findByCriterea(@RequestBody TaxeVo taxeVo){ return taxeTNBService.findByCriterea(taxeVo);}

    @GetMapping("/terrain/ref/{ref}/annee/{annee}")
    public TaxeTNB findByTerrainReferenceAndAnnee(@PathVariable String ref,@PathVariable Long annee) {
        return taxeTNBService.findByTerrainReferenceAndAnnee(ref, annee);
    }

    /*public Result simuler(TaxeTNB taxeTNB) {
        return taxeTNBService.simuler(taxeTNB);
    }*/

    public List<TaxeTNB> findByTerrainId(Long id) {
        return taxeTNBService.findByTerrainId(id);
    }

    @GetMapping("/anneeMin/{anneeMin}/anneeMax/{anneeMax}")
    public Map<Integer, Double> calcStatistics(@PathVariable Integer anneeMin,@PathVariable Integer anneeMax) {
        return taxeTNBService.calcStatistics(anneeMin, anneeMax);
    }
}
