package com.example.demo.service;

import com.example.demo.bean.Taux;
import com.example.demo.dao.TauxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauxService {
    @Autowired
    private TauxDao tauxDao;

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
}
