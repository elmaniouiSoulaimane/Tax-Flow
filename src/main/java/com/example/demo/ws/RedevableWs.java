package com.example.demo.ws;

import com.example.demo.bean.Redevable;
import com.example.demo.service.RedevableService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/redevable")
@CrossOrigin("http://localhost:4200")
public class RedevableWs {
    @Autowired
    private RedevableService redevableService;

    @GetMapping("/RechercheRedevable/{ref}")
    public Redevable findByRef(@PathVariable String ref) {
        return redevableService.findByRef(ref);
    }

    @DeleteMapping("/DeleteRedevable/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return redevableService.deleteByRef(ref);
    }

    @GetMapping("/ListRedevables")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }

    @PostMapping("/AjouterRedevable")

    public Result save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }
    @PutMapping("/ModifierRedevable/{ref}")
    public Result updateRedevable(@PathVariable String ref,@RequestBody Redevable redevableMod) {
        return redevableService.updateRedevable(ref, redevableMod);
    }
    @Transactional
    @DeleteMapping("/deleteRedevabe/{ref}")
    public Result deleteRedevable(@PathVariable String ref) {
        return redevableService.deleteRedevable(ref);
    }
}
