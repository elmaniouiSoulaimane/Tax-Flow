package com.example.demo.ws;

import com.example.demo.bean.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/categorie")
@CrossOrigin("http://localhost:4200")
public class CategoryWs {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/RechercheCategorieByCode/{code}")
    public Category findByCode(@PathVariable String code) {
        return categoryService.findByCode(code);
    }
    @GetMapping("/RechercheCategorieByNom/{libelle}")
    public Category findByLibelle(@PathVariable String libelle) {
        return categoryService.findByLibelle(libelle);
    }
    @GetMapping("/ListDesCategories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
    @PostMapping("/AjouterCategorie")
    public int save(@RequestBody Category category) {
        return categoryService.save(category);
    }
    @DeleteMapping("/SupprimerCategorieByNom/{libelle}")
    public Integer deleteByLibelle(@PathVariable String libelle){
        return categoryService.deleteByLibelle(libelle);
    }
    @PutMapping("/ModifierCategorie/{id}")
    public Category update(@RequestBody Category nouveauCategory,@PathVariable Long id){
        return categoryService.update(nouveauCategory,id);
    }

}
