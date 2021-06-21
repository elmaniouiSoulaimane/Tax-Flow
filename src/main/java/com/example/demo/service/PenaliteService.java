package com.example.demo.service;

import com.example.demo.bean.Penalite;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.dao.PenaliteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Service
public class PenaliteService {
    @Autowired
    private PenaliteDao penaliteDao;
    /*@PersistenceContext
    private EntityManager manager;
    Penalite penalite;*/

    public List<Penalite> findAll(){
        return findAll();
    }

    public Penalite findfindByTaxeTNBAnnee(Long annee){
        return penaliteDao.findByTaxeTNBAnnee(annee);
    }

    public Penalite findByTaxeTNBTerrainReference(String reference){
        return penaliteDao.findByTaxeTNBTerrainReference(reference);
    }

    @Transactional
    public Integer deleteByTaxeTNBAnnee(Year annee){
        return penaliteDao.deleteByTaxeTNBAnnee(annee);
        /*Penalite penalite = manager.find(Penalite.class,penaliteDao.findByTaxeTNBAnnee(annee).getId());
        if(penalite != null){
            manager.remove(penalite);
        }*/
    }

    public Integer save(Penalite penlaite){
        if(penaliteDao.findById(penlaite.getId()) != null){
            return -1;
        }else{
            penaliteDao.save(penlaite);
            return 1;
        }
    }

    public Penalite update(Penalite nouveauPenalite,Long id){
        return penaliteDao.findById(id).map(penalite -> {
            TaxeTNBService taxeTNBService = new TaxeTNBService();
            TaxeTNB taxeTNB;
            taxeTNB = taxeTNBService.findByAnnee(nouveauPenalite.getTaxeTNB().getAnnee());
            return penaliteDao.save(taxeTNB.setPenalite());
        }).orElseGet(()->{
           nouveauPenalite.setId(id);
           return penaliteDao.save(nouveauPenalite);
        });
    }




}
