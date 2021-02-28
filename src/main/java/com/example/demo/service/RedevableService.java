package com.example.demo.service;
import com.example.demo.bean.Redevable;
import com.example.demo.dao.RedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableService {
    @Autowired
    private RedevableDao redevableDao;

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
}

