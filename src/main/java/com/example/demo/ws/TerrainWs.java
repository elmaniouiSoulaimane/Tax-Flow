package com.example.demo.ws;

import com.example.demo.bean.Terrain;
import com.example.demo.service.TerrainService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/terrain")
@CrossOrigin("http://localhost:4200")
public class TerrainWs {
    @Autowired
    public TerrainService terrainService;
    @GetMapping("/RechrcheTerByCat/{code}")
    public Terrain findByCategory_Code(String code) {
        return terrainService.findByCategory_Code(code);
    }

    @PostMapping("/AjouterTerrain")
    public Result save(@RequestBody Terrain terrain) {
        return terrainService.save(terrain);
    }
    @GetMapping("/RechercherTerrain/{reference}")
    public Terrain findByReference(@PathVariable String reference) {
        return terrainService.findByReference(reference);
    }

    @Transactional
    @DeleteMapping("DeleteTerrain/{reference}")
    public Result deleteByReference(@PathVariable String reference) {
        return terrainService.deleteByReference(reference);
    }
    @PutMapping("/ModifierTerrain/{ref}")
    public Result updateTerrain(@PathVariable String ref, @RequestBody Terrain terrainMod) {
        return terrainService.updateTerrain(ref, terrainMod);
    }
    @GetMapping("/ListTerrains")
    public List<Terrain> findAll() {
        return terrainService.findAll();
    }
}
