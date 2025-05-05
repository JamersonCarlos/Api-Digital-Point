package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Locais_Trabalho")
public class LocaisTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    private String identificador;
    @Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double latitude = 0.0;

    @Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double longitude = 0.0;
    
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean localTrabalho = false;


    @ManyToMany(mappedBy = "locaisTrabalhos")
    @JsonBackReference
    private List<SetorDepartamento> setorDepartamento = new ArrayList<>();

    
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

    public void setSetorDepartamento(List<SetorDepartamento> setorDepartamento) {
        this.setorDepartamento = setorDepartamento;
    }

    public List<SetorDepartamento> getSetorDepartamento() {
        return this.setorDepartamento;
    }

    
    
    


    
}
