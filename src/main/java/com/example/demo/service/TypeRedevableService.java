package com.example.demo.service;

import com.example.demo.bean.TypeRedevable;
import com.example.demo.dao.TypeRedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeRedevableService {
    @Autowired
    TypeRedevableDao typeRedevableDao;
    public List<TypeRedevable> typesRede=new ArrayList<>();


    public TypeRedevable findByNomType(String nomType){
        return typeRedevableDao.findByNomType(nomType);
    }

    public int save(TypeRedevable typeRedevable){
        if(findByNomType(typeRedevable.getNomType())!=null){
            return -1;
        }else{
            typeRedevableDao.save(typeRedevable);
            return 1;
        }
    }

    public List<TypeRedevable> findAll(){
        return typeRedevableDao.findAll();
    }

    @Transactional
    public Integer deleteByNomType(String nomType){
        return typeRedevableDao.deleteByNomType(nomType);
    }

    @Transactional
    public TypeRedevable update(TypeRedevable nouveauTypeRedevable, Long id){
        return typeRedevableDao.findById(id).map(type ->{
            type.setNomType(nouveauTypeRedevable.getNomType());
            return typeRedevableDao.save(type);
        }).orElseGet(() -> {
            nouveauTypeRedevable.setId(id);
            return typeRedevableDao.save(nouveauTypeRedevable);
        });
    }
}
