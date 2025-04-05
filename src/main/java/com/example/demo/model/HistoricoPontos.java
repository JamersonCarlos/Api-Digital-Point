package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historico")
public class HistoricoPontos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    private double latitude; 
    private double longitude; 
    private LocalDateTime createdAt;
    private LocalDateTime finallyAt; 
    private String justificativa; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao_id", referencedColumnName = "id")
    private LocaisTrabalho localizacao;

    @ManyToOne
    @JoinColumn(name = "user_login", referencedColumnName = "login")
    private User user;


    public HistoricoPontos() {
    }

    public HistoricoPontos(double latitude, double longitude, LocaisTrabalho localizacao, LocalDateTime createdAt, String justificativa, User user, LocalDateTime finallyAt) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.localizacao = localizacao; 
        this.user = user; 
        this.justificativa = justificativa; 
        this.finallyAt = finallyAt; 

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public LocaisTrabalho getLocalizacao() {
        return localizacao;
    }


    public void setLocalizacao(LocaisTrabalho localizacao) {
        this.localizacao = localizacao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getFinallyAt() {
        return finallyAt;
    }

    public void setFinallyAt(LocalDateTime finallyAt) {
        this.finallyAt = finallyAt;
    } 


    
    
}
