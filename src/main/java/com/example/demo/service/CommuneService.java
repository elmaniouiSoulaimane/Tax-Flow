package com.example.demo.service;

import com.example.demo.bean.Commune;
import com.example.demo.dao.CommuneDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneService {
    @Autowired
    private CommuneDao communeDao;

    public List<Commune> findByVille_Name(String name) {
        return communeDao.findByVille_Name(name);
    }

    public int deleteByNomComunne(String name) {
        return communeDao.deleteByNomComunne(name);
    }

    public Commune findByNomComunne(String name) {
        return communeDao.findByNomComunne(name);
    }

    public List<Commune> findAll() {
        return communeDao.findAll();
    }

    public Result save(Commune entity) {
        Result result = new Result("CommuneInput",entity);
        if (findByNomComunne(entity.getNomComunne())!=null){
            result.addError(-1,"Commune Deja exist");
        }
        if (entity.getNomComunne()==null){
            result.addError(-2,"nom Commune est vide");
        }
        if (entity.getVille()==null){
            result.addError(-3,"ville est vide");
        }
        if (entity.getNumTel()==null || entity.getNumTel().length()<10 ||
                entity.getNumTel().length()>10){
            result.addError(-4,"numero tell vide ou depasse 10 chiffre");
        }
        if (result.hasNoError()){
            communeDao.save(entity);
            result.addInfo(1,"Commune Ajouter");
        }

        return result;
    }

    public  Result ModiferCommune(String nom,Commune ModCommune){
        Result result = new Result("ModiferInput",ModCommune);
        Commune commune = new Commune();
        if (findByNomComunne(nom)!= null){
            commune = findByNomComunne(nom);
        }else {
            result.addError(-1,"Commune n'exist pas");
        }
        if (ModCommune.getNumTel()==null){
            result.addError(-2,"Numero telephone est vide");
        }
        if (ModCommune.getVille()==null){
            result.addError(-3,"ville est vide");
        }
        if (ModCommune.getNomComunne()==null){
            result.addError(-4,"nom commune est vide");
        }
        if(ModCommune.getNumTel().length() < 10 ||ModCommune.getNumTel().length() > 10){
            result.addError(-5,"numero taille est differente de 10");
        }
        if (result.hasNoError()){
            commune.setNomComunne(ModCommune.getNomComunne());
            commune.setNumTel(ModCommune.getNumTel());
            commune.setVille(ModCommune.getVille());
            Commune communeModifer= communeDao.save(commune);
            result.addInfo(1,"Commune Modfier " + communeModifer );
        }
        return result;
    }
}
