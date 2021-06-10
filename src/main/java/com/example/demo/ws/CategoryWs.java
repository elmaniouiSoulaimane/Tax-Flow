package com.example.demo.ws;

import com.example.demo.bean.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("terrain/category")
public class CategoryWs {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/code/{code}")
    public Category findByCode(@PathVariable String code) {
        return categoryService.findByCode(code);
    }
    @GetMapping("/libelle/{libelle}")
    public Category findByLibelle(@PathVariable String libelle) {
        return categoryService.findByLibelle(libelle);
    }
    @GetMapping("/")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Category category) {
        return categoryService.save(category);
    }
    @DeleteMapping("libelle/{libelle}")
    public Integer deleteByLibelle(@PathVariable String libelle){
        return categoryService.deleteByLibelle(libelle);
    }
    @PutMapping("category/{id}")
    public Category update(@RequestBody Category nouveauCategory,@PathVariable Long id){
        return categoryService.update(nouveauCategory,id);
    }

}
