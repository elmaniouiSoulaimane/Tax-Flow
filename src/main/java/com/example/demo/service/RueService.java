package com.example.demo.service;

import com.example.demo.bean.Rue;
import com.example.demo.dao.RueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RueService {
    public int save (Rue rue){
        if (findByCode(rue.getCode())!=null)
            return -1;
        else {
            rueDao.save(rue);
            return 1;
        }
    }
    public Rue findByCode(String code) {
        return rueDao.findByCode(code);
    }

    public Rue findByLibelle(String libelle) {
        return rueDao.findByLibelle(libelle);
    }

    public List<Rue> findAll() {
        return rueDao.findAll();
    }

    @Autowired
    private RueDao rueDao;


}

