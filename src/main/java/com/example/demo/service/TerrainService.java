package com.example.demo.service;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import com.example.demo.vo.TaxeVo;
import com.example.demo.vo.TerrainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;


@Service
public class TerrainService {
    @Autowired
    private TerrainDao terrainDao;
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Integer save(Terrain terrain) {
        if (findByReference(terrain.getReference()) != null) {
            return -1;
        } else {
            terrainDao.save(terrain);
            return 1;
        }
    }

    public Terrain findByReference(String reference) {
        return terrainDao.findByReference(reference);
    }

    @Transactional
    public Integer deleteByReference(String reference) {
        return terrainDao.deleteByReference(reference);
    }

    public List<Terrain> findAll() {
        return terrainDao.findAll();
    }

    @Transactional
    public Terrain update(Terrain nouveauTerrain,Long id){
        return terrainDao.findById(id).map(result ->{
            result.setReference(nouveauTerrain.getReference());
            result.setAdresse(nouveauTerrain.getAdresse());
            result.setSurface(nouveauTerrain.getSurface());
            result.setCategory(nouveauTerrain.getCategory());
            result.setRedevable(nouveauTerrain.getRedevable());
            result.setDateDeclaration(nouveauTerrain.getDateDeclaration());
            result.setDateAchat(nouveauTerrain.getDateAchat());
            result.setDeclaree(nouveauTerrain.isDeclaree());
            return terrainDao.save(result);
        }).orElseGet(() ->{
            nouveauTerrain.setId(id);
            return terrainDao.save(nouveauTerrain);
        });
    }

    public List<Terrain> findByCriterea(TerrainVo terrainVo){
        String query="Select t from Terrain t where 1=1";
        if(terrainVo.getReference()!=null){
            query+=" And t.reference='"+terrainVo.getReference()+"'";
        }
        if(terrainVo.getAdresse()!=null){
            query+=" And t.adresse='"+terrainVo.getAdresse()+"'";
        }
        if(terrainVo.getSurface()!=null){
            query+=" And t.surface='"+terrainVo.getSurface()+"'";
        }
        if(terrainVo.getCategory()!=null){
            query+=" And t.category.libelle='"+terrainVo.getCategory()+"'";
        }
        if(terrainVo.getRedevable()!=null){
            query+=" And t.redevable.ref='"+terrainVo.getRedevable()+"'";
        }
        if(terrainVo.getDateDeclaration()!=null){
            query+=" And t.dateDeclaration='"+terrainVo.getDateDeclaration()+"'";
        }
        if(terrainVo.getDateAchat()!=null){
            query+=" And t.dateAchat='"+terrainVo.getDateAchat()+"'";
        }
        query+=" And t.declaree='"+terrainVo.isDeclaree()+"'";
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

  /*  public Map<Integer,Integer> calcStatisticsParAnnee(Date dateMin, Date dateMax){
        Map<Integer,Integer> res= new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateMin);
        Integer anneeMin = cal.get(Calendar.YEAR);
        cal.clear();
        cal.setTime(dateMax);
        Integer anneeMax= cal.get(Calendar.YEAR);
        Integer periodAnne= anneeMax - anneeMin;
        Integer[] annees=new Integer[periodAnne];
        cal.clear();
        Integer k=0;
        for(int i=anneeMin;i<=anneeMax;i++){
            annees[k]=i;
            k++;
        }
        k=0;
        for (int i = anneeMin; i <=anneeMax ; i++) {
            res.put(i, terrainDao.calcStatistics(new Integer(annees[k])));
            k++;
        }
        return res;
    }*/

}
