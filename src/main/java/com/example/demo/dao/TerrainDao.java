package com.example.demo.dao;

import com.example.demo.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {

    Terrain findByReference(String reference);
    Integer deleteByReference(String reference);
    Terrain findByCategory_Code(String code);
}
