package com.example.demo.dao;

import com.example.demo.bean.TypeRedevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRedevableDao extends JpaRepository<TypeRedevable,Long> {
    TypeRedevable findByNomType (String nomType);
    Integer deleteByNomType(String nomType);
}
