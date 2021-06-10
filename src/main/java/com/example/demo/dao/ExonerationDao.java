package com.example.demo.dao;

import com.example.demo.bean.Exoneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.Date;

@Repository
public interface ExonerationDao extends JpaRepository<Exoneration,Long> {
    Exoneration findByTaxeTNBAnnee(Year annee);
    Exoneration findByTaxeTNB_Terrain_Reference(String reference);
    Integer deleteByTaxeTNBAnnee(Year annee);
}
