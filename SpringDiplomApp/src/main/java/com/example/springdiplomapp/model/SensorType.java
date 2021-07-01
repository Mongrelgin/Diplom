package com.example.springdiplomapp.model;

import javax.persistence.*;

@Entity
@Table(name = "sensor_types")
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;

    public SensorType() {}

    public SensorType( String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SensorType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
