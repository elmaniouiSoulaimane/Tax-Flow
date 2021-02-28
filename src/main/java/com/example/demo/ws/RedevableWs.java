package com.example.demo.ws;

import com.example.demo.bean.Redevable;
import com.example.demo.service.RedevableService;
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
    @GetMapping("/referance/{ref}")
    public Redevable findByRef(@PathVariable String ref) {
        return redevableService.findByRef(ref);
    }
    @DeleteMapping("/referance/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return redevableService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }
}
