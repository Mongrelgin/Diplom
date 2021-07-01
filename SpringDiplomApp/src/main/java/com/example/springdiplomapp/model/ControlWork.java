package com.example.springdiplomapp.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "control_work")
public class ControlWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_control")
    private Long id_control;

    @Column(name = "worktime")
    private Timestamp worktime;

    public ControlWork(){}

    public ControlWork(Long id_control, Timestamp worktime) {
        this.id_control = id_control;
        this.worktime = worktime;
    }

    public Long getId() {
        return id;
    }

    public void setId_control(Long id_control) {
        this.id_control = id_control;
    }

    public Long getId_control() {
        return id_control;
    }

    public void setWorktime(Timestamp worktime) {
        this.worktime = worktime;
    }

    public Timestamp getWorktime() {
        return worktime;
    }
}
