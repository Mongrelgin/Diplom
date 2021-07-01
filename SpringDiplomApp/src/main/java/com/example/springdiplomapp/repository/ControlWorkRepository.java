package com.example.springdiplomapp.repository;

import com.example.springdiplomapp.model.ControlWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlWorkRepository extends JpaRepository<ControlWork, Long> {
}
