package com.example.demo.service;

import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TerrainService {

    public Terrain findByCategory_Code(String code) {
        return terrainDao.findByCategory_Code(code);
    }

    public Result save(Terrain terrain) {
        Result result= new Result("TerrainInput",terrain);
        if (findByReference(terrain.getReference()) != null) {
            result.addError(-1,"terrain deja exist");
        }
        if (terrain.getReference()==null){
            result.addError(-2,"refetance vide");
        }
        if (terrain.getAdresse()==null){
            result.addError(-3,"adresse vide");
        }
        if (terrain.getCategory()==null){
            result.addError(-4,"categorie vide");
        }
        if (terrain.getRedevable()==null){
            result.addError(-5,"redevable vide");
        }

        if (result.hasNoError()){
            terrainDao.save(terrain);
            result.addInfo(1,"terrain Ajouter");
        }
        return result;
    }

    public Terrain findByReference(String reference) {
        return terrainDao.findByReference(reference);
    }

    @Transactional
    public Result deleteByReference(String reference) {
        Result result= new Result("TerrainDelete",reference);
        if (findByReference(reference)==null){
            result.addError(-1,"terrain n'exist pas");
        }
        if (result.hasNoError()){
            terrainDao.deleteByReference(reference);
            result.addInfo(1,"terrain ajouter");
        }

        return result;
    }

    public Result updateTerrain(String ref,Terrain terrainMod){
        Result result = new Result("TerrainUpdate",ref);
        Terrain terrain = findByReference(ref);
        if (terrain==null){
            result.addError(-1,"terrain n'exist pas");
        }
        if (result.hasNoError()){
            terrain.setSurface(terrainMod.getSurface());
            terrain.setAdresse(terrainMod.getAdresse());
            terrain.setCategory(terrainMod.getCategory());
            terrain.setRedevable(terrainMod.getRedevable());
            terrain.setReference(terrainMod.getReference());

            Terrain terrainUpater = terrainDao.save(terrain);
            result.addInfo(1,"terrain updated");
        }
        return result;
    }
    public List<Terrain> findAll() {
        return terrainDao.findAll();
    }

    @Autowired
    private TerrainDao terrainDao;

}
