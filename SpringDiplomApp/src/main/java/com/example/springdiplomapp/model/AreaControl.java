package com.example.springdiplomapp.model;

import javax.persistence.*;

@Entity
@Table(name = "areas_controls")
public class AreaControl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_area")
    private Long id_area;
    @Column(name = "id_control")
    private Long id_control;

    public AreaControl() {}

    public AreaControl(Long id, Long id_area, Long id_control) {
        this.id = id;
        this.id_area = id_area;
        this.id_control = id_control;
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

    public Long getId_control() {
        return id_control;
    }

    public void setId_control(Long id_control) {
        this.id_control = id_control;
    }
}
