package com.example.springdiplomapp.repository;

import com.example.springdiplomapp.model.AreaControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaControlRepository extends JpaRepository<AreaControl, Long> {
}
