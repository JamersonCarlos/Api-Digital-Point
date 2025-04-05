package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.model.LocaisTrabalho;

public class ResponseHistoricoAllUserDTO {

    private int id; 
    private LocalDateTime createdAt; 
    private LocalDateTime finallyAt; 
    private LocaisTrabalho localizacao;
    private Double latitude; 
    private Double longitude;
    private String justificativa;

    
    
    public ResponseHistoricoAllUserDTO() {
    }

    
    public ResponseHistoricoAllUserDTO(LocalDateTime createdAt, LocalDateTime finallyAt, LocaisTrabalho localizacao, Double latitude, Double longitude) {
        this.createdAt = createdAt;
        this.finallyAt = finallyAt;
        this.localizacao = localizacao;
        this.latitude = latitude; 
        this.longitude = longitude; 
    }

    


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public LocalDateTime getFinallyAt() {
        return finallyAt;
    }


    public void setFinallyAt(LocalDateTime finallyAt) {
        this.finallyAt = finallyAt;
    }


    public LocaisTrabalho getLocalizacao() {
        return localizacao;
    }


    public void setLocalizacao(LocaisTrabalho localizacao) {
        this.localizacao = localizacao;
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


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getJustificativa() {
        return justificativa;
    }


    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    


    
    

    

}
