package com.example.demo.service;
import com.example.demo.bean.Redevable;
import com.example.demo.dao.RedevableDao;
import com.example.demo.vo.RedevableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RedevableService {
    @Autowired
    private RedevableDao redevableDao;
    @Autowired
    private EntityManager entityManager;

    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return redevableDao.deleteByRef(ref);
    }

    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

    public int save(Redevable redevable) {
        if (findByRef(redevable.getRef())!=null){
            return -1;
        }else {
            redevableDao.save(redevable);
            return 1;
        }
    }

    @Transactional
    public Redevable update(Redevable nouveauRedevable,Long id){
        return redevableDao.findById(id).map(result ->{
            result.setRef(nouveauRedevable.getRef());
            result.setAdresse(nouveauRedevable.getAdresse());
            result.setNomCommercial(nouveauRedevable.getNomCommercial());
            result.setTypeRedevable(nouveauRedevable.getTypeRedevable());
            return redevableDao.save(result);
        }).orElseGet(() ->{
           nouveauRedevable.setId(id);
           return redevableDao.save(nouveauRedevable);
        });
    }

    public List<Redevable> findByCriterea(RedevableVo redevableVo){
        String query="Select r d=from Redevable r where 1=1";
        if(redevableVo.getRef()!=null){
            query+= "And r.ref='"+redevableVo.getRef()+"'";
        }
        if(redevableVo.getAdresse()!=null){
            query+="And r.adresse='"+redevableVo.getAdresse()+"'";
        }
        if(redevableVo.getTypeRedevable()!=null){
            query+="And r.typeRedevable='"+redevableVo.getTypeRedevable()+"'";
        }
        System.out.println("query = " + query);
        return entityManager.createQuery(query).getResultList();
    }

}

