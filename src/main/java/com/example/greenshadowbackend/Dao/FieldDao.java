package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.FieldEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldDao {
    Optional<FieldEntity> findByFieldName(String name);
}
