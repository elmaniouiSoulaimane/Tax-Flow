package com.example.demo.dao;

import com.example.demo.bean.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseDao extends JpaRepository<Adresse,Long> {
    Adresse findByRef(String ref);
    int deleteByRef(String ref);
    List<Adresse>findByQuartier_Id(Long id);
}
