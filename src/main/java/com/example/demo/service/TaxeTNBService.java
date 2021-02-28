package com.example.demo.service;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.Taux;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TaxeTNBDao;
import com.example.demo.service.util.Result;
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

    public Result save(TaxeTNB taxeTNB) {
        return save(taxeTNB,false);
    }

    public Result simuler(TaxeTNB taxeTNB) {
        return save(taxeTNB,true);
    }

    private Result save(TaxeTNB taxeTNB,boolean simuler) {
        Result result= new Result("taxeTNBInput",taxeTNB);
        Terrain terrain = terrainService.findByReference(taxeTNB.getTerrain().getReference());
        Redevable redevable= redevableService.findByRef(terrain.getRedevable().getRef());
        if (findByTerrainReferenceAndAnnee(taxeTNB.getTerrain().getReference(), taxeTNB.getAnnee())!=null) {
           result.addError(-1,"Taxe deja paye");
        } if (terrain==null){
            result.addError(-2,"Terrain non existant");
        } if (redevable==null){
            result.addError(-3,"Redevable non existant");
        } if(terrain.getCategory()==null || terrain.getCategory().getId()==null){
            result.addError(-4,"Categorie non existant");
        }
        Taux taux = tauxService.findByCategoryId(terrain.getCategory().getId());

        if (taux == null){
            result.addError(-5,"Taux non existant");
        }
        if(result.hasNoError()) {
            taxeTNB.setRedevable(redevable);
            taxeTNB.setTerrain(terrain);
            taxeTNB.setTaux(taux);
            taxeTNB.setMontantDeBase(taxeTNB.getTaux().getPrix()*taxeTNB.getTerrain().getSurface());
            if (simuler == false)
            taxeTNBDao.save(taxeTNB);
           result.addInfo(1,"Taxe Saved");
        }
        return result;
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
