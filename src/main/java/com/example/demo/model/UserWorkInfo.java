package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_work_info")
public class UserWorkInfo {
        
        @Id
        @Column(unique = true)
        private String matricula;
        
        private String regime_trabalho; 
        private int carga_horaria; 
        private String secretaria; 
        private String departamento; 
        private double salario;


        public UserWorkInfo() {
        }

        public UserWorkInfo(String regime_trabalho, int carga_horaria, String secretaria, String departamento,
                        double salario) {
                this.regime_trabalho = regime_trabalho;
                this.carga_horaria = carga_horaria;
                this.secretaria = secretaria;
                this.departamento = departamento;
                this.salario = salario;
        }

        

        public String getRegime_trabalho() {
                return regime_trabalho;
        }
        public void setRegime_trabalho(String regime_trabalho) {
                this.regime_trabalho = regime_trabalho;
        }
        public int getCarga_horaria() {
                return carga_horaria;
        }
        public void setCarga_horaria(int carga_horaria) {
                this.carga_horaria = carga_horaria;
        }
        public String getSecretaria() {
                return secretaria;
        }
        public void setSecretaria(String secretaria) {
                this.secretaria = secretaria;
        }
        public String getDepartamento() {
                return departamento;
        }
        public void setDepartamento(String departamento) {
                this.departamento = departamento;
        }
        public double getSalario() {
                return salario;
        }
        public void setSalario(double salario) {
                this.salario = salario;
        }

        public String getMatricula() {
                return matricula;
        }

        public void setMatricula(String matricula) {
                this.matricula = matricula;
        }


        
}
