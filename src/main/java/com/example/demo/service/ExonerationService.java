package com.example.demo.service;

import com.example.demo.bean.Exoneration;
import com.example.demo.bean.Penalite;
import com.example.demo.dao.ExonerationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.Date;
import java.util.List;

@Service
public class ExonerationService {
    @Autowired
    public ExonerationDao exonerationDao;

    public Exoneration findByTaxeTNBAnnee(Year annee){
        return exonerationDao.findByTaxeTNBAnnee(annee);
    }

    public Exoneration findByTaxeTNB_Terrain_Reference(String reference){
        return exonerationDao.findByTaxeTNB_Terrain_Reference(reference);
    }

    public List<Exoneration> findAll(){
        return exonerationDao.findAll();
    }
    @Transactional
    public Integer deleteByTaxeTNBAnnee(Year annee){
        return exonerationDao.deleteByTaxeTNBAnnee(annee);
    }

    public Exoneration save(Exoneration exoneration){
        return exonerationDao.save(exoneration);
    }

    public Exoneration update(Exoneration nouveauExoneration, Long id){
        return exonerationDao.findById(id).map(exoneration -> {
            exoneration.setTaxeTNB(nouveauExoneration.getTaxeTNB());
            exoneration.setMontantDeReduction(nouveauExoneration.getMontantDeReduction());
            return exonerationDao.save(exoneration);
        }).orElseGet(()->{
           nouveauExoneration.setId(id);
           return exonerationDao.save(nouveauExoneration);
        });
    }
}
