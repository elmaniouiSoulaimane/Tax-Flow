package com.example.demo.ws;

import com.example.demo.bean.Redevable;
import com.example.demo.service.RedevableService;
import com.example.demo.vo.RedevableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/Redevable")
@CrossOrigin("http://localhost:4200")
public class RedevableWs {
    @Autowired
    private RedevableService redevableService;
    @GetMapping("/RechercheRedevableByNom/{nomCommercial}")
    public Redevable findByNomCommercial(@PathVariable String nomCommercial) {
        return redevableService.findByNomCommmercial(nomCommercial);
    }
    @DeleteMapping("/SupprimerRedevableByNom/{ref}")
    @Transactional
    public int deleteByNomCommercial(@PathVariable String nomCommercial) {
        return redevableService.deleteByNomCommercial(nomCommercial);
    }
    @GetMapping("/ListDesRedevable")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }
    @PostMapping("/AjouterRedevable")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }
    @PutMapping("ModifierRedevable/{id}")
    public Redevable update(@RequestBody Redevable nouveauRedevable, @PathVariable Long id){
        return redevableService.update(nouveauRedevable,id);
    }
    @PostMapping("/criterea")
    public List<Redevable> findByCriterea(@RequestBody RedevableVo redevableVo){
        return redevableService.findByCriterea(redevableVo);
    }
    @GetMapping("RechercheRedevableByNOm/{nomCommercial}")
    public Redevable findByNomCommmercial(@PathVariable String nomCommercial) {
        return redevableService.findByNomCommmercial(nomCommercial);
    }
    @GetMapping("RechercheRedevableByRef/{ref}")
    public Redevable findByRef(@PathVariable String ref) {
        return redevableService.findByRef(ref);
    }
    @Transactional
    @DeleteMapping("/SupprimerRedevableByRef/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return redevableService.deleteByRef(ref);
    }
}
