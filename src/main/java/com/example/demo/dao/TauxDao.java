package com.example.demo.dao;

import com.example.demo.bean.Taux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxDao extends JpaRepository<Taux,Long> {
    Taux findByCategoryId(Long id);
    Integer deleteByCategory_Libelle(String libelle);
}
