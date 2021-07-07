package com.example.demo.dao;

import com.example.demo.bean.Quartier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartierDao extends JpaRepository<Quartier,Long> {
    Quartier findByCode(String code);
    int deleteByCode(String code);
    Quartier findByRue_Ville_Code(String code);
    List<Quartier> findByRue_Code(String code);
    List<Quartier> findByRue_Id(Integer code);
}
