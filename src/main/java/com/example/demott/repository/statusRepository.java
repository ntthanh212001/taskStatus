package com.example.demott.repository;

import com.example.demott.entity.statusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface statusRepository extends JpaRepository<statusEntity, Integer> {
    List<statusEntity> findAll();
    statusEntity getById(Integer id);
    statusEntity findItemById(Integer id);
    List<statusEntity> findByName(String name);
}
