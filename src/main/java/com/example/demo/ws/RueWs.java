package com.example.demo.ws;

import com.example.demo.bean.Rue;
import com.example.demo.service.RueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/rue")
public class RueWs {
    @PostMapping("/")
    public int save(@RequestBody Rue rue) {
        return rueService.save(rue);
    }
@GetMapping("/code/{code}")
    public Rue findByCode(@PathVariable String code) {
        return rueService.findByCode(code);
    }
@GetMapping("/libelle/{libelle}")
    public Rue findByLibelle(@PathVariable String libelle) {
        return rueService.findByLibelle(libelle);
    }
    @GetMapping("/")
    public List<Rue> findAll() {
        return rueService.findAll();
    }

    @Autowired
private RueService rueService;
}
