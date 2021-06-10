package com.example.demo.ws;

import com.example.demo.bean.TypeRedevable;
import com.example.demo.service.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("redevable/type-redevable")
public class TypeRedevableWs {
    @Autowired
    TypeRedevableService typeRedevableService;

    @GetMapping("/nomRedevable/{nomRedevable}")
    public TypeRedevable findByNomType(@PathVariable String nomRedevable){
        return typeRedevableService.findByNomType(nomRedevable);
    }

    @PostMapping("/")
    public int save(@RequestBody TypeRedevable typeRedevable){
        return typeRedevableService.save(typeRedevable);
    }

    @GetMapping("/")
    public List<TypeRedevable> findAll(){
        return typeRedevableService.findAll();
    }

    @DeleteMapping("/nom-type-redevable/{nomType}")
    public Integer deleteByNomType(@PathVariable String nomType){
        return typeRedevableService.deleteByNomType(nomType);
    }

    @PutMapping("/type_redevable/{id}")
    public TypeRedevable update(@RequestBody TypeRedevable nouveauTypeRedevable,@PathVariable Long id){
        return typeRedevableService.update(nouveauTypeRedevable,id);
    }
}
