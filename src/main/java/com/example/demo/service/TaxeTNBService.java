package com.example.demo.service;

import com.example.demo.bean.Redevable;
import com.example.demo.bean.Taux;
import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TaxeTNBDao;
import com.example.demo.service.util.Result;
import com.example.demo.vo.TaxeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private EntityManager entityManager;
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


    public List<TaxeTNB> findByCriterea(TaxeVo taxeVo){
        String query="Select t from TaxeTNB t where 1=1";
        if(taxeVo.getRedevable()!=null){
            query+=" And t.redevable.ref='"+taxeVo.getRedevable()+"'";
        }
        if(taxeVo.getTerrain()!=null){
            query+=" And t.terrain.reference='"+taxeVo.getTerrain()+"'";
        }
        if(taxeVo.getAnneeMin()!=null){
            query+=" And t.annee>'"+taxeVo.getAnneeMin()+"'";
        }
        if(taxeVo.getAnneeMax()!=null){
            query+=" And t.annee<='"+taxeVo.getAnneeMax()+"'";
        }
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

    public Map<Integer, Double> calcStatistics(Integer anneeMin, Integer anneeMax) {
        Map<Integer, Double> res= new HashMap<>();
        for (int i = anneeMin; i <=anneeMax ; i++) {
            res.put(i, taxeTNBDao.calcStatistics(new Long(i+"")));
        }
        return res;
    }




}
