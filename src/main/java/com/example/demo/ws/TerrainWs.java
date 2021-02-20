package com.example.demo.ws;

import com.example.demo.bean.Terrain;
import com.example.demo.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/terrain")
public class TerrainWs {
    @PostMapping("/")
    public Integer save(@RequestBody Terrain terrain) {
        return terrainService.save(terrain);
    }

    @GetMapping("/reference/{reference}")
    public Terrain findByReference(@PathVariable String reference) {
        return terrainService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public Integer deleteByReference(@PathVariable String reference) {
        return terrainService.deleteByReference(reference);
    }

    @GetMapping("/")
    public List<Terrain> findAll() {
        return terrainService.findAll();
    }

    @Autowired
    public TerrainService terrainService;

}
