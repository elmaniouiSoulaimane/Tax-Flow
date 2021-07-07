package com.example.demo.ws;

import com.example.demo.bean.Rue;
import com.example.demo.service.RueService;

import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TaxFlow/V1/Rue")
@CrossOrigin("http://localhost:4200")
public class RueProvided {
    @Autowired
    private RueService rueService;
    @GetMapping("/ListRues")
    public List<Rue> findAll() {
        return rueService.findAll();
    }
    @GetMapping("/RecharcheRueByCode/{code}")
    public Rue findByCode(@PathVariable String code) {
        return rueService.findByCode(code);
    }
    @PostMapping("/AjouterRue")
    public Result save(@RequestBody Rue rue) {
        return rueService.save(rue);
    }
    @PutMapping("/ModifierRue/{code}")
    public Result updateRue(@PathVariable String code, @RequestBody Rue rueMod) {
        return rueService.updateRue(code, rueMod);
    }
    @Transactional
    @DeleteMapping("/SupprimerRue/{code}")
    public Result deleteByCode(@PathVariable String code) {
        return rueService.deleteByCode(code);
    }
    @GetMapping("/findRueByVille/{code}")
    public List<Rue> findByVille_Code(@PathVariable String code) {
        return rueService.findByVille_Code(code);
    }
}
