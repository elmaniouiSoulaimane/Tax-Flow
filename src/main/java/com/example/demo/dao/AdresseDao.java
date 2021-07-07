package com.example.demo.dao;

import com.example.demo.bean.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseDao extends JpaRepository<Adresse,Long> {
    Adresse findByQuartierId(Long id);
    int deleteByQuartierIdAndNumLot(Long id,String num);
    Adresse findByQuartierIdAndNumLot(Long id,String num);
    List<Adresse>findByQuartier_Id(Long id);

}
