package com.example.demo.service;
import com.example.demo.bean.Redevable;
import com.example.demo.dao.RedevableDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableService {
    @Autowired
    private RedevableDao redevableDao;
    //recherche des redevable ref est le cin
    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return redevableDao.deleteByRef(ref);
    }
    //List des redevabke
    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }
    //Ajouter Redevable
    public Result save(Redevable redevable) {
        Result result = new Result("redevableInput",redevable);
        if (findByRef(redevable.getRef())!=null){
            result.addError(-1,"redevable deja exist");
        }
        if (redevable.getRef()==null){
            result.addError(-2,"champ cin est vide");
        }

        if (redevable.getAdresse() == null) {
            result.addError(-4,"champ adresse est vide");
        }
        if (result.hasNoError()){
            redevableDao.save(redevable);
            result.addInfo(1,"redevable Ajouter");
        }
        return result;
    }
    //ModifierRedevable
    public Result updateRedevable(String ref,Redevable redevableMod){
        Result result = new Result("RedevableUpdate",ref);
        Redevable redevable = findByRef(ref);
        if (redevable==null){
            result.addError(-1,"redevable vide");
        }
        if(redevableMod.getAdresse()==null){
            result.addError(-2,"Adresse est vide");
        }
        if (redevableMod.getRef()==null){
            result.addError(-3,"Cin est vide");
        }


        if (result.hasNoError()){
            redevable.setRef(redevableMod.getRef());
            redevable.setAdresse(redevableMod.getAdresse());

            Redevable updatedRedevable = redevableDao.save(redevable);

            result.addInfo(1,"redevable Ajouter");
        }
        return result;
    }
    //deleteRedevable
    public Result deleteRedevable(String ref){
        Result result = new Result("deleteRedevable",ref);
        if (findByRef(ref)==null){
            result.addError(-1,"redevable n'exist pas");
        }
        if (result.hasNoError()){
            redevableDao.deleteByRef(ref);
            result.addInfo(1,"refevable suprimer");
        }
        return result;
    }
}

