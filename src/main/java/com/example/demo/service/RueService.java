package com.example.demo.service;


import com.example.demo.bean.Rue;
import com.example.demo.dao.RueDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RueService {
    @Autowired
    private RueDao rueDao;

    public List<Rue> findAll() {
        return rueDao.findAll();
    }

    public Rue findByCode(String code) {
        return rueDao.findByCode(code);
    }

    //Ajouter un rue
    public Result save(Rue rue) {
        Result result = new Result("RueInput",rue);

        if (findByCode(rue.getCode())!=null){
            result.addError(-1,"Rue deja exist");
        }
        if (rue.getCode()==null){
            result.addError(-2,"code rue est vide");
        }
        if (rue.getName()==null){
            result.addError(-3,"nom rue est vide");
        }
        if (rue.getVille() == null){
            result.addError(-4,"Quartier est vide");
        }
        if (result.hasNoError()){
            Rue saveRue = new Rue();
            saveRue.setCode(rue.getCode());
            saveRue.setName(rue.getName().toUpperCase());
            saveRue.setVille(rue.getVille());
            rueDao.save(saveRue);
            result.addInfo(1,"Rue ajouter");
        }
        return result;
    }
    public Result updateRue(String code,Rue rueMod){
        Result result = new Result("RueUpdate",code);
        Rue rue = findByCode(code);
        if (rue == null){
            result.addError(-1,"Rue Introuvable");
        }
        if (rueMod.getCode()==null){
            result.addError(-2,"Code rue est vide");
        }
        if (rueMod.getName()==null){
            result.addError(-3,"Nom rue est vide");
        }
        if (result.hasNoError()){
            rue.setCode(rueMod.getCode());
            rue.setName(rueMod.getName());
            rue.setVille(rueMod.getVille());
            Rue updatedRue = rueDao.save(rue);
            result.addInfo(1,"Rue modifier");
        }
        return result;
    }

    public Result deleteByCode(String code) {
        Result result = new Result("RueDelete",code);
        if (rueDao.findByCode(code)==null){
            result.addError(-1,"champ code rue est vide");
        }
        if (result.hasNoError()){
            rueDao.deleteByCode(code);
            result.addInfo(1,"Rue Supprimer");
        }

        return result;
    }

    public List<Rue> findByVille_Code(String code) {
        return rueDao.findByVille_Code(code);
    }
}
