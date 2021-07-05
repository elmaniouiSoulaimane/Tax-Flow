package com.example.demo.service;

import com.example.demo.bean.Taux;
import com.example.demo.dao.TauxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TauxService {
    @Autowired
    private TauxDao tauxDao;
    public  Taux findTauxById(Long id){
        return tauxDao.findById(id).get();
    }
    public Taux findByCategoryId(Long id) {
        return tauxDao.findByCategoryId(id);
    }

    public List<Taux> findAll() {
        return tauxDao.findAll();
    }

    public int save(Taux taux) {
        if (findByCategoryId(taux.getCategory().getId())!=null){
            return -1;
        }else {
            tauxDao.save(taux);
            return 1;
        }
    }

    @Transactional
    public Integer deleteByCategory_Libelle(String libelle){
        return tauxDao.deleteByCategory_Libelle(libelle);
    }


    public Taux update(Taux nouveauTaux,Long id){
        return tauxDao.findById(id).map(taux -> {
            taux.setPrix(nouveauTaux.getPrix());
            taux.setCategory(nouveauTaux.getCategory());
            return tauxDao.save(taux);
        }).orElseGet(()->{
           nouveauTaux.setId(id);
           return tauxDao.save(nouveauTaux);
        });
    }
}
