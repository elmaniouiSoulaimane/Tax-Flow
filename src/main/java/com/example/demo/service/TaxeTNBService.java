package com.example.demo.service;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TaxeTNBDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeTNBService {

    public Integer save(TaxeTNB taxeTNB) {
        if (findByTerrainReferenceAndAnnee(taxeTNB.getTerrain().getReference(), taxeTNB.getAnnee())!=null) {
            return -1;
        } else {
            taxeTNBDao.save(taxeTNB);
            return 1;
        }
    }



    public List<TaxeTNB> findAll() {
        return taxeTNBDao.findAll();
    }


    public Terrain findByTerrainReferenceAndAnnee(String ref, Long annee) {
        return taxeTNBDao.findByTerrainReferenceAndAnnee(ref, annee);
    }

    @Autowired
    public TaxeTNBDao taxeTNBDao;
}
