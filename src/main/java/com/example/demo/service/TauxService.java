package com.example.demo.service;

import com.example.demo.bean.Taux;
import com.example.demo.dao.TauxDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TauxService {
    @Autowired
    private TauxDao tauxDao;
    public  Taux findByID(Long id){
        return tauxDao.findById(id).get();
    }
    //find taux by categorie
    public Taux findByCategoryId(Long id) {
        return tauxDao.findByCategoryId(id);
    }
    //list des taux
    public List<Taux> findAll() {
        return tauxDao.findAll();
    }
    //Ajouter un taux
    public Result save(Taux taux) {
        Result result = new Result("TauxInput",taux);
        if (findByCategoryId(taux.getCategory().getId())!=null) {
            result.addError(-1,"taux n'exit pas");
        }
        if (taux.getSrfaceMax()==null){
            result.addError(-2,"champ surface max est vide");
        }
        if (taux.getSurfaceMin()==null){
            result.addError(-3,"chap surface min est vide");
        }
        if (taux.getPrix()==0){
            result.addError(-4,"champ prix est vide");
        }
        if (taux.getCategory()==null){
            result.addError(-5,"champ categorie est vide");
        }
        if (result.hasNoError()){
            tauxDao.save(taux);
            result.addInfo(1,"taux Ajouter");
        }
        return result;
    }
    //modifier un taux
   /* public Result updateTaux(Long id,Taux tauxMod){
        Result result = new Result("TauxUpdate",id);
        Taux taux = tauxDao.findById(id).get();
        if (taux == null){
            result.addError(-1,"taux n'existe pas");
        }
        if (result.hasNoError()){
            taux.setPrix(tauxMod.getPrix());
            taux.setCategory(tauxMod.getCategory());
            taux.setSrfaceMax(tauxMod.getSrfaceMax());
            taux.setSurfaceMin(tauxMod.getSurfaceMin());
            Taux updatedTaux =  tauxDao.save(taux);
            result.addInfo(1,"taux modifier");
        }
        return result;
    }
    //delete taux
    public Result deleteTaux(Long id){
        Result result = new Result("deleteTaux",id);
        Taux taux =tauxDao.findById(id).get();
        if (taux==null){
            result.addError(-1,"introuvable");

        }
        if (result.hasNoError()){
            tauxDao.deleteById(taux.getId());
            result.addInfo(1,"taux supprimer");
        }
        return result;
    }*/

    @Transactional
    public Integer deleteByCategory_Libelle(String libelle){
        return tauxDao.deleteByCategory_Libelle(libelle);
    }


    public Taux update(Taux nouveauTaux,Long id){
        return tauxDao.findById(id).map(taux -> {
            taux.setPrix(nouveauTaux.getPrix());
            taux.setCategory(nouveauTaux.getCategory());
            taux.setSurfaceMin(nouveauTaux.getSurfaceMin());
            taux.setSrfaceMax(nouveauTaux.getSrfaceMax());
            return tauxDao.save(taux);
        }).orElseGet(()->{
           nouveauTaux.setId(id);
           return tauxDao.save(nouveauTaux);
        });
    }
}
