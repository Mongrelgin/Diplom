package com.example.springdiplomapp.model;

import javax.persistence.*;

@Entity
@Table(name = "control_types")
public class ControlType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;

    public ControlType() {}

    public ControlType(String name) {
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
}
