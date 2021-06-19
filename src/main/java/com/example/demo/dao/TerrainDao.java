package com.example.demo.dao;

import com.example.demo.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.Date;

@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {

    Terrain findByReference(String reference);
    Integer deleteByReference(String reference);

}
