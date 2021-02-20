package com.example.demo.service;

import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    public Integer save(Terrain terrain) {
        if (findByReference(terrain.getReference()) != null) {
            return -1;
        } else {
            terrainDao.save(terrain);
            return 1;
        }
    }

    public Terrain findByReference(String reference) {
        return terrainDao.findByReference(reference);
    }

    @Transactional
    public Integer deleteByReference(String reference) {
        return terrainDao.deleteByReference(reference);
    }

    public List<Terrain> findAll() {
        return terrainDao.findAll();
    }

    @Autowired
    private TerrainDao terrainDao;

}
