package com.example.demo.service;

import com.example.demo.bean.Category;
import com.example.demo.dao.CategoryDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private  TerrainService terrainService;
    //Ajouter Une Categorie
    public Result save (Category category){
        Result result= new Result("CategorieInput",category);
        if (findByCode(category.getCode())!=null){
            result.addError(-1,"code deja exist");
        }
        if (findByLibelle(category.getLibelle())!=null){
            result.addError(-2,"nom categorie deja exist");
        }
        if (category.getCode()==null){
            result.addError(-3,"Champs code est vide");
        }
        if (category.getLibelle()==null){
            result.addError(-4,"champ nom categorie est vide");
        }
        if (result.hasNoError()){
            categoryDao.save(category);
            result.addInfo(1,"Categorie est ajouter");
        }
        return result;
    }
    //Rechercher code
    public Category findByCode(String code) {
        return categoryDao.findByCode(code);
    }
    //recherche libelle de categorie
    public Category findByLibelle(String libelle) {
        return categoryDao.findByLibelle(libelle);
    }
    //List des categories
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
    //Suprimer categorie
    public Result deleteByCategory(String code) {
        Result result= new Result("CategorieInput",code);
        if (categoryDao.findByCode(code) == null){
            result.addError(-1,"categorie n'exist pas");
        }
        if (terrainService.findByCategory_Code(code) != null){
            result.addError(-2,"impossible de supprimer terrain avec cette categorie exist");
        }
        if (result.hasNoError()){
            categoryDao.deleteByCode(code);
            result.addInfo(1,"categorie est supprimer");
        }
        return result;
    }
    //Modifer categorie
    public Result updateCategory(String code,Category categoryMod){
        Result result= new Result("CategorieUpdate",code);
        Category category = categoryDao.findByCode(code);
        if (category == null){
            result.addError(-1,"categorie n'exist pas");
        }
        if(categoryMod.getCode()==null){
            result.addError(-2,"code est vide");
        }
        if (categoryMod.getLibelle()==null){
            result.addError(-3,"nom categorie est vide");
        }

        if (result.hasNoError()){
            category.setCode(categoryMod.getCode());
            category.setLibelle(categoryMod.getLibelle());
            Category updatedCategory = categoryDao.save(category);
            result.addInfo(1,"categorie modifer");
        }
        return result;
    }
}
