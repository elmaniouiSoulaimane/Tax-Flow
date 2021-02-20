package com.example.demo.ws;

import com.example.demo.bean.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boisson/category")
public class CategoryWs {
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

    @Autowired
    private CategoryService categoryService;
}
