package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private String nome; 
        private String rua;
        private String bairro; 
        private String número; 
        private String complemento; 
        private String cep; 
        private String cidade; 


        
        @OneToOne
        @JoinColumn(name = "chefe_matricula") // chave estrangeira para a matrícula do funcionário
        private Funcionario chefe;

        @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<SetorDepartamento> setores;

        public Departamento() {
        }
        

        public Departamento(String nome, String rua, String bairro, String número, String complemento, String cep,
                        String cidade, double latitude, double longitude, Funcionario chefe) {
                this.nome = nome;
                this.rua = rua;
                this.bairro = bairro;
                this.número = número;
                this.complemento = complemento;
                this.cep = cep;
                this.cidade = cidade;
                this.chefe = chefe; 
        }


        public int getId() {
                return id;
        }
        public void setId(int id) {
                this.id = id;
        }
        public String getNome() {
                return nome;
        }
        public void setNome(String nome) {
                this.nome = nome;
        }
        public String getRua() {
                return rua;
        }
        public void setRua(String rua) {
                this.rua = rua;
        }
        public String getBairro() {
                return bairro;
        }
        public void setBairro(String bairro) {
                this.bairro = bairro;
        }
        public String getNúmero() {
                return número;
        }
        public void setNúmero(String número) {
                this.número = número;
        }
        public String getComplemento() {
                return complemento;
        }
        public void setComplemento(String complemento) {
                this.complemento = complemento;
        }
        public String getCep() {
                return cep;
        }
        public void setCep(String cep) {
                this.cep = cep;
        }
        public String getCidade() {
                return cidade;
        }
        public void setCidade(String cidade) {
                this.cidade = cidade;
        }


        
        public Funcionario getChefe() {
                return chefe;
        }


        public void setChefe(Funcionario chefe) {
                this.chefe = chefe;
        }

        
}
