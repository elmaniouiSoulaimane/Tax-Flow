package com.example.demo.service;

import com.example.demo.bean.Category;
import com.example.demo.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public int save (Category category){
        if (findByCode(category.getCode())!=null)
            return -1;
            else {
                categoryDao.save(category);
                return 1;
        }
    }
    public Category findByCode(String code) {
        return categoryDao.findByCode(code);
    }

    public Category findByLibelle(String libelle) {
        return categoryDao.findByLibelle(libelle);
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Transactional
    public Integer deleteByLibelle(String libelle){
        return categoryDao.deleteByLibelle(libelle);
    }

    @Transactional
    public Category update(Category nouveauCategory, Long id){
        return categoryDao.findById(id).map(category ->{
            category.setCode(nouveauCategory.getCode());
            category.setLibelle(nouveauCategory.getLibelle());
            return categoryDao.save(category);
        }).orElseGet(()->{
           nouveauCategory.setId(id);
           return categoryDao.save(nouveauCategory);
        });
    }


}
