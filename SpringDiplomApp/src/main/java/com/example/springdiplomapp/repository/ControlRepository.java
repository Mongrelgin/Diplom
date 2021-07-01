package com.example.springdiplomapp.repository;

import com.example.springdiplomapp.model.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {
}
