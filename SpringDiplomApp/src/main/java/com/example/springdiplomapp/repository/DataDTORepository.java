package com.example.springdiplomapp.repository;

import com.example.springdiplomapp.dto.DataDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDTORepository extends JpaRepository<DataDTO, String> {
    @Query(value = "SELECT d.id, s.ip, st.name, a.name as area_name, d.date_time, d.data FROM data d " +
            "JOIN sensors s ON d.id_sensor = s.id " +
            "JOIN sensor_types st ON s.id_sensor_type = st.id " +
            "JOIN areas a ON d.id_area = a.id", nativeQuery = true)
    List<DataDTO> findAllData();
}

