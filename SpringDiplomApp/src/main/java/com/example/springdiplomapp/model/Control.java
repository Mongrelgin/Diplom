package com.example.springdiplomapp.model;

import javax.persistence.*;

@Entity
@Table(name = "controls")
public class Control {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "id_control_type")
    private Long id_type;

    @Column(name = "settings")
    private Integer settings;

    @Column(name = "enabled")
    private Boolean enabled;

    public Control() {}

    public Control(String ip, Long id_type, Integer settings, Boolean enabled) {
        this.settings = settings;
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

    public Integer getSettings() {
        return settings;
    }

    public void setSettings(Integer settings) {
        this.settings = settings;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
