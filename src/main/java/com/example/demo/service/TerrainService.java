package com.example.demo.service;

import com.example.demo.bean.Terrain;
import com.example.demo.dao.TerrainDao;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService implements TerrainDao {


    @Override
    public Terrain findByReference(String reference) {
        return null;
    }

    @Override
    public Integer deleteByReference(String reference) {
        return null;
    }

    @Override
    public Integer updateByReference(String reference) {
        return null;
    }

    @Override
    public List<Terrain> findAll() {
        return null;
    }

    @Override
    public List<Terrain> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Terrain> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Terrain> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Terrain terrain) {

    }

    @Override
    public void deleteAll(Iterable<? extends Terrain> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Terrain> S save(S s) {
        return null;
    }

    @Override
    public <S extends Terrain> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Terrain> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Terrain> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Terrain> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Terrain getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Terrain> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Terrain> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Terrain> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Terrain> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Terrain> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Terrain> boolean exists(Example<S> example) {
        return false;
    }
}
