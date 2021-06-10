package com.example.demo.service;

import com.example.demo.bean.Adresse;
import com.example.demo.bean.User;
import com.example.demo.dao.AdresseDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {
    @Autowired
    private AdresseDao adresseDao;

    public List<Adresse> findAll() {
        return adresseDao.findAll();
    }

    public Result save(Adresse adresse) {
        Result result = new Result("AdresseInput",adresse);
        if (adresseDao.findByRef(adresse.getRef())!=null){
            result.addError(-1,"adresse deja existant");
        }
        if (adresse.getNumLot()==null){
            result.addError(-2,"champ numLot est vide");
        }
        if (adresse.getRef()==null){
            result.addError(-3,"champ ref est vide");
        }
        if (adresse.getQuartier()==null){
            result.addError(-3,"champ quartier est vide");
        }
        if (result.hasNoError()){
            adresseDao.save(adresse);
        }
        return result;
    }
    //Modifier Utilisateur
    public Result updateAdresse(String ref,Adresse adresseMod){
        Result result = new Result("AdresseUpdate",adresseMod);
        Adresse adresse = findByRef(ref);
        if (adresse == null){
            result.addError(-1,"adresse n'exist pas");
        }
        if (result.hasNoError()){
            adresse.setNumLot(adresseMod.getNumLot());
            adresse.setRef(adresseMod.getRef());
            adresse.setQuartier(adresseMod.getQuartier());
            Adresse updatedAdresse = adresseDao.save(adresse);
            result.addInfo(1,"Adresse est modifier");
        }
        return result;
    }
    //Supprimer User

    public Result deleteByAdresseRef(String ref) {
        Result result = new Result("AdresseDelete",ref);
        if (findByRef(ref)==null){
            result.addError(-1,"adresse n'exist pas");
        }
        if (result.hasNoError()){
            adresseDao.deleteByRef(ref);
        }
        return result;
    }


    public Adresse findByRef(String ref) {
        return adresseDao.findByRef(ref);
    }

    public List<Adresse> findByQuartier_Id(Long id) {
        return adresseDao.findByQuartier_Id(id);
    }
}
