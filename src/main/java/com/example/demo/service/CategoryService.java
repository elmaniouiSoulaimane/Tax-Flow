package com.example.demo.service;

import com.example.demo.bean.Category;
import com.example.demo.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

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

    @Autowired
    private CategoryDao categoryDao;
}
