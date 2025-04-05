package com.example.demo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Locais_Trabalho")
public class LocaisTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    private String identificador;
    private Double latitude; 
    private Double longitude; 
    private boolean localTrabalho;
    
    
    public LocaisTrabalho() {
    }

    public LocaisTrabalho(String identificador) {
        this.identificador = identificador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean isLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(boolean localTrabalho) {
        this.localTrabalho = localTrabalho;
    } 
    
    


    
}
