package com.example.demo.dao;

import com.example.demo.bean.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneDao extends JpaRepository<Commune,Long> {
    Commune findByNomComunne(String name);
    List<Commune> findByVille_Name(String name);
    int deleteByNomComunne(String name);
}
