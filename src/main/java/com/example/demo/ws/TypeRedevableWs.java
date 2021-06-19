package com.example.demo.ws;

import com.example.demo.bean.TypeRedevable;
import com.example.demo.service.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TaxFlow/type-redevable")
public class TypeRedevableWs {
    @Autowired
    TypeRedevableService typeRedevableService;

    @GetMapping("/RechercheTypeRedevable/{nomRedevable}")
    public TypeRedevable findByNomType(@PathVariable String nomRedevable){
        return typeRedevableService.findByNomType(nomRedevable);
    }

    @PostMapping("/AjouterTypeRedevable")
    public int save(@RequestBody TypeRedevable typeRedevable){
        return typeRedevableService.save(typeRedevable);
    }

    @GetMapping("/ListTypeRedevables")
    public List<TypeRedevable> findAll(){
        return typeRedevableService.findAll();
    }

    @Transactional
    @DeleteMapping("SupprimerTypeRedevable/{nomType}")
    public Integer deleteByNomType(@PathVariable String nomType){
        return typeRedevableService.deleteByNomType(nomType);
    }

    @PutMapping("ModifierTypeRedevable/{id}")
    public TypeRedevable update(@RequestBody TypeRedevable nouveauTypeRedevable,@PathVariable Long id){
        return typeRedevableService.update(nouveauTypeRedevable,id);
    }
}
