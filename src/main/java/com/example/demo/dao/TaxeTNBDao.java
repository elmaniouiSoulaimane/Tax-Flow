package com.example.demo.dao;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Year;

@Repository
public interface TaxeTNBDao extends JpaRepository<com.example.demo.bean.TaxeTNB, Long> {

    TaxeTNB findByTerrainReferenceAndAnnee(String ref, Long annee);
    TaxeTNB findByTerrainId(Long id);
    @Query("select sum(t.montantDeBase) from  TaxeTNB  t WHERE t.annee= :annee")
    Double calcStatistics(@Param(value="annee") Long annee);
    Integer deleteByAnnee(Long annee);

}
