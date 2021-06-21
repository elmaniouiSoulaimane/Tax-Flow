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
@RequestMapping("boisson/redevable")
public class RedevableWs {
    @Autowired
    private RedevableService redevableService;
    @GetMapping("/nomCommercial/{nomCommercial}")
    public Redevable findByNomCommercial(@PathVariable String nomCommercial) {
        return redevableService.findByNomCommmercial(nomCommercial);
    }
    @DeleteMapping("/referance/{ref}")
    @Transactional
    public int deleteByNomCommercial(@PathVariable String nomCommercial) {
        return redevableService.deleteByNomCommercial(nomCommercial);
    }
    @GetMapping("/")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }
    @PutMapping("redevable/{id}")
    public Redevable update(@RequestBody Redevable nouveauRedevable, Long id){
        return redevableService.update(nouveauRedevable,id);
    }
    @PostMapping("/criterea")
    public List<Redevable> findByCriterea(@RequestBody RedevableVo redevableVo){
        return redevableService.findByCriterea(redevableVo);
    }
}
