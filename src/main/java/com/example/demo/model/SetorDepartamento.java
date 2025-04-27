package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "setores_departamento")
public class SetorDepartamento {        
        

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id; 
        private String nome; 

     
        @OneToMany(mappedBy = "localTrabalho", cascade = CascadeType.REMOVE, orphanRemoval = true)
        private List<LocaisTrabalho> locaisTrabalhos; 

        @OneToMany(mappedBy = "setorDepartamento", cascade = CascadeType.REMOVE, orphanRemoval = true)
        @JsonManagedReference
        private List<Funcionario> funcionarios;

        @ManyToOne
        @JoinColumn(name = "departamento_id")
        @JsonBackReference
        private Departamento departamento;

        @ManyToOne
        @JoinColumn(name = "chefe_matricula") // chave estrangeira para a matrícula do funcionário
        private Funcionario chefe;

        

        public SetorDepartamento() {
        }


        public SetorDepartamento(String nome, Departamento departamento) {
                this.nome = nome;
                this.departamento = departamento;
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

        public Departamento getDepartamento() {
                return departamento;
        }

        public void setDepartamento(Departamento departamento) {
                this.departamento = departamento;
        }

        public List<LocaisTrabalho> getLocaisTrabalhos() {
                return locaisTrabalhos;
        }

        public void setLocaisTrabalhos(List<LocaisTrabalho> locaisTrabalhos) {
                this.locaisTrabalhos = locaisTrabalhos;
        }

        public Funcionario getChefe() {
                return chefe;
        }

        public void setChefe(Funcionario chefe) {
                this.chefe = chefe;
        } 

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

        
        
        
}
