package com.example.springdiplomapp.model;

import javax.persistence.*;

@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "id_sensor_type")
    private Long id_type;

    @Column(name = "enabled")
    private Boolean enabled;

    public Sensor() {}

    public Sensor(String ip, Long id_type, Boolean enabled) {
        this.ip = ip;
        this.id_type = id_type;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getId_type() {
        return id_type;
    }

    public void setId_type(Long id_type) {
        this.id_type = id_type;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
