package com.example.demo.service;


import com.example.demo.bean.Ville;
import com.example.demo.dao.VilleDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    @Autowired
    private VilleDao villeDao;

    public List<Ville> findAll() {
        return villeDao.findAll();
    }

    public Ville findByCode(String code) {
        return villeDao.findByCode(code);
    }
    //supprimer ville

    public Result deleteByCode(String code) {
        Result result = new Result("villeDelete",code);
        if (villeDao.findByCode(code)== null){
            result.addError(-1,"ville n'exist pas");
        }
        if (result.hasNoError()){
            villeDao.deleteByCode(code);
            result.addInfo(1,"ville supprimer");
        }
        return result;
    }

    //Ajouter ville
    public Result save(Ville ville) {
        Result result = new Result("villeInput",ville);
        if (findByCode(ville.getCode())!=null){
            result.addError(-1,"ville deja exist");
        }
        if(ville.getName()==null){
            result.addError(-2,"Champs Nom Ville Vide");
        }
        if (result.hasNoError()){
            villeDao.save(ville);
            result.addInfo(1,"ville Ajouter");
        }

        return result;
    }
    //Modifier ville
    public Result updateVille(String code,Ville villeMod){
        Result result = new Result("villeModifier",code);
        Ville ville = villeDao.findByCode(code);
        if (ville == null){
            result.addError(-1,"quatier introuvable");
        }

        if (result.hasNoError()){
            ville.setName(villeMod.getName());
            ville.setCode(villeMod.getCode());
            Ville updatedVille = villeDao.save(ville);
            result.addInfo(1,"ville modifier");
        }
        return result;
    }
}
