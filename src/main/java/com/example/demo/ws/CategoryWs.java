package com.example.demo.ws;

import com.example.demo.bean.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("boisson/category")
@CrossOrigin("http://localhost:4200")
public class CategoryWs {
    @GetMapping("/RechercheCategories/{code}")
    public Category findByCode(@PathVariable String code) {
        return categoryService.findByCode(code);
    }
    @GetMapping("/libelle/{libelle}")
    public Category findByLibelle(@PathVariable String libelle) {
        return categoryService.findByLibelle(libelle);
    }
    @GetMapping("/ListCategories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
    @PostMapping("/AjouterCategorie")
    public Result save(@RequestBody Category category) {
        return categoryService.save(category);
    }
    @Transactional
    @DeleteMapping("/DeleteCategories/{code}")
    public Result deleteByCategory(@PathVariable String code) {
        return categoryService.deleteByCategory(code);
    }
    @PutMapping("/ModifierCategories/{code}")
    public Result updateCategory(@PathVariable String code, @RequestBody Category categoryMod) {
        return categoryService.updateCategory(code, categoryMod);
    }

    @Autowired
    private CategoryService categoryService;
}
