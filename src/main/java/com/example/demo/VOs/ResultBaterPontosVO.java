package com.example.demo.VOs;

import java.time.LocalDateTime;

public class ResultBaterPontosVO {
    private LocalDateTime createdAt; 
    private double latitude; 
    private double longitude;
    private String local; 

    
    
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    
    public ResultBaterPontosVO() {
    }
    public ResultBaterPontosVO(LocalDateTime created_at, double latitude, double longitude, String local) {
        this.local = local;
        this.createdAt = created_at;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    } 

    

}
