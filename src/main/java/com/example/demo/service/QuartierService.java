package com.example.demo.service;


import com.example.demo.bean.Quartier;
import com.example.demo.dao.QuartierDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuartierService {
    @Autowired
    private QuartierDao quartierDao;

    public List<Quartier> findAll() {
        return quartierDao.findAll();
    }

    public Quartier findByCode(String code) {
        return quartierDao.findByCode(code);
    }

    //Ajouter Quartier
    public Result save(Quartier quartier) {
        Result result = new Result("quartierInput",quartier);
        if (findByCode(quartier.getCode())!=null){
            result.addError(-1,"quartier deja exist");
        }
        if (quartier.getName()==null){
            result.addError(-2,"Champ name est vide");
        }
        if (quartier.getCode()==null){
            result.addError(-3,"Champ code est null");
        }
        if (quartier.getRue()==null){
            result.addError(-4,"champ Rue est null");
        }
        if (result.hasNoError()){
            quartierDao.save(quartier);
            result.addInfo(1,"quartier Ajouter");
        }

        return result;
    }
    //Modifier quartier
    public Result updateQuartier(String code,Quartier quartierMod){
        Result result = new Result("quartierModifier",code);
        Quartier quartier = findByCode(code);
        if (quartier == null){
            result.addError(-1,"quatier introuvable");
        }
        if (quartierMod.getCode()==null){
            result.addError(-2,"champ code est vide");
        }
        if (quartierMod.getName()==null){
            result.addError(-3,"champ nom quartier est vide");
        }
        if (result.hasNoError()){
            quartier.setName(quartierMod.getName());
            quartier.setCode(quartierMod.getCode());
            quartier.setRue(quartierMod.getRue());
            Quartier updatedQuartier = quartierDao.save(quartier);
            result.addInfo(1,"quartier modifier");
        }
        return result;
    }
    public Result deleteByCode(String code) {
        Result result = new Result("quartierDelete",code);
        if (findByCode(code)== null){
            result.addError(-1,"quartier n'exist pas");
        }
        if (result.hasNoError()){
            quartierDao.deleteByCode(code);
            result.addInfo(1,"quartier supprimer");
        }
        return result;
    }

    public Quartier findByRue_Ville_Code(String code) {
        return quartierDao.findByRue_Ville_Code(code);
    }

    public List<Quartier> findByRue_Code(String code) {
        return quartierDao.findByRue_Code(code);
    }

    public List<Quartier> findByRue_Id(Integer code) {
        return quartierDao.findByRue_Id(code);
    }
}
