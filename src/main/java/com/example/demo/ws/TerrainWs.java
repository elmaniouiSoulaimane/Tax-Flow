package com.example.demo.ws;

import com.example.demo.bean.Terrain;
import com.example.demo.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taxe-tnb/terrain")
public class TerrainWs {
    @Autowired
    public TerrainService terrainService;

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

    @PutMapping("terrain/{id}")
    public Terrain update(@RequestBody Terrain nouveauTerrain,Long id){
        return terrainService.update(nouveauTerrain,id);
    }

}
