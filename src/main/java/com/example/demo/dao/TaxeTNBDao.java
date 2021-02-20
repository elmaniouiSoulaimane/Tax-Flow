package com.example.demo.dao;

import com.example.demo.bean.TaxeTNB;
import com.example.demo.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeTNBDao extends JpaRepository<com.example.demo.bean.TaxeTNB, Long> {

    Terrain findByTerrainReferenceAndAnnee(String ref, Long annee);
}
