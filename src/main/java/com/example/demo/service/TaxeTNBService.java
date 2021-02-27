package com.example.demo.service;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.Taux;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TaxeTNBDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeTNBService {
    @Autowired
    public TaxeTNBDao taxeTNBDao;
    @Autowired
    private RedevableService redevableService;
    @Autowired
    private TerrainService terrainService;
    @Autowired
    private TauxService tauxService;



    public Integer save(TaxeTNB taxeTNB) {
        Terrain terrain = terrainService.findByReference(taxeTNB.getTerrain().getReference());
        Redevable redevable= redevableService.findByRef(terrain.getRedevable().getRef());
        Taux taux = tauxService.findByCategoryId(terrain.getCategory().getId());
        if (findByTerrainReferenceAndAnnee(taxeTNB.getTerrain().getReference(), taxeTNB.getAnnee())!=null) {
            return -1;
        }else if (terrain==null){
            return -2;
        }else if (redevable==null){
            return -3;
        }else if (taux == null){
            return -4;
        } else {
            taxeTNB.setRedevable(redevable);
            taxeTNB.setTerrain(terrain);
            taxeTNB.setTaux(taux);
            taxeTNB.setMontantDeBase(taxeTNB.getTaux().getPrix()*taxeTNB.getTerrain().getSurface());
            taxeTNBDao.save(taxeTNB);
            return 1;
        }
    }

    public TaxeTNB findByTerrainId(Long id) {
        return taxeTNBDao.findByTerrainId(id);
    }

    public List<TaxeTNB> findAll() {
        return taxeTNBDao.findAll();
    }


    public Terrain findByTerrainReferenceAndAnnee(String ref, Long annee) {
        return taxeTNBDao.findByTerrainReferenceAndAnnee(ref, annee);
    }


}
