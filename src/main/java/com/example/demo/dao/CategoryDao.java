package com.example.demo.dao;

import com.example.demo.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao  extends JpaRepository<Category,Long> {
    Category findByCode(String code);
    Category findByLibelle(String libelle);

}
