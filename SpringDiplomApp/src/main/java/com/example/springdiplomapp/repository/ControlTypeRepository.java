package com.example.springdiplomapp.repository;

import com.example.springdiplomapp.model.ControlType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlTypeRepository extends JpaRepository<ControlType, Long> {
}
