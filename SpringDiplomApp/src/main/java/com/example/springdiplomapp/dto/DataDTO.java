package com.example.springdiplomapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class DataDTO {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "ip")
    private String sensor_ip;
    @Column(name = "name")
    private String sensor_type_name;
    @Column(name = "area_name")
    private String area_name;
    @Column(name = "date_time")
    private Timestamp date_time;
    @Column(name = "data")
    private String data;

    public DataDTO() {}

    public DataDTO(Long id, String sensor_ip, String sensor_type_name, String area_name, Timestamp date_time, String data) {
        this.id = id;
        this.sensor_ip = sensor_ip;
        this.sensor_type_name = sensor_type_name;
        this.area_name = area_name;
        this.date_time = date_time;
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }


    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public String getSensor_type_name() {
        return sensor_type_name;
    }

    public String getSensor_ip() {
        return sensor_ip;
    }

    public void setSensor_ip(String sensor_ip) {
        this.sensor_ip = sensor_ip;
    }

    public void setSensor_type_name(String sensor_type_name) {
        this.sensor_type_name = sensor_type_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataDTO dataDTO = (DataDTO) o;
        return Objects.equals(id, dataDTO.id) && Objects.equals(sensor_ip, dataDTO.sensor_ip) && Objects.equals(sensor_type_name, dataDTO.sensor_type_name) && Objects.equals(area_name, dataDTO.area_name) && Objects.equals(date_time, dataDTO.date_time) && Objects.equals(data, dataDTO.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sensor_ip, sensor_type_name, area_name, date_time, data);
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "id=" + id +
                ", sensor_ip='" + sensor_ip + '\'' +
                ", sensor_type_name='" + sensor_type_name + '\'' +
                ", area_name='" + area_name + '\'' +
                ", date_time=" + date_time +
                ", data='" + data + '\'' +
                '}';
    }
}

