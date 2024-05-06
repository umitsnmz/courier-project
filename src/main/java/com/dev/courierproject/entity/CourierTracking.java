package com.dev.courierproject.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(schema = "PUBLIC" ,name = "COURIER_TRACKING")
public class CourierTracking {
    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "COURIERID")
    private Long courierId;

    @Column(name = "LAT")
    private Double lat;

    @Column(name = "LNG")
    private Double lng;

    @Column(name = "TIME")
    private LocalDateTime time;

    @Column(name = "ENTRANCE")
    private Boolean entrance = false;
    @Column(name = "STORE")
    private String store ;

    @PrePersist
    public void prePersist() {
        time = LocalDateTime.now();
    }

    public CourierTracking(long id, long courierId, double lat, double lng, LocalDateTime time,boolean entrance,String store) {
        this.id = id;
        this.courierId = courierId;
        this.lat = lat;
        this.lng = lng;
        this.time = time;
        this.entrance=entrance;
        this.store=store;
    }

    public CourierTracking() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Boolean getEntrance() {
        return entrance;
    }

    public void setEntrance(Boolean entrance) {
        this.entrance = entrance;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
