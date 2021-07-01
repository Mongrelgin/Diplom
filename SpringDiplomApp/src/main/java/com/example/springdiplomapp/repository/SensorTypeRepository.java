package com.example.springdiplomapp.repository;

import com.example.springdiplomapp.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
}
