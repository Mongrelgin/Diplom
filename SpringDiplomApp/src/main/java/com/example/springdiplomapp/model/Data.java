package com.example.springdiplomapp.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_sensor")
    private Long id_sensor;
    @Column(name = "id_area")
    private Long id_area;
    @Column(name = "date_time")
    private Timestamp date_time;
    @Column(name = "data")
    private String data;

    public Data() {}

    public Data(Long id, Long id_sensor, Long id_area, Timestamp date_time, String data) {
        this.id = id;
        this.id_sensor = id_sensor;
        this.id_area = id_area;
        this.date_time = date_time;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Long getId_area() {
        return id_area;
    }

    public void setId_area(Long id_area) {
        this.id_area = id_area;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }
}
