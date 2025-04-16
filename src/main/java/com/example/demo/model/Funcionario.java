package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
        
        @Id
        @Column(unique = true)
        private String matricula;
        
        private int cod_regime; 
        private int carga_horaria; 

        private double salario;
        private String telefone; 
        private String email; 
        private String sexo; 

        @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
        private boolean chefe; 

        @ManyToOne
        @JoinColumn(name = "setor_id")
        private SetorDepartamento setorDepartamento;
        
        public Funcionario() {
        
        }

        public Funcionario(String matricula, int cod_regime, int carga_horaria, double salario, String telefone,
                        String email, String sexo, boolean chefe, SetorDepartamento setorDepartamento) {
                this.matricula = matricula;
                this.cod_regime = cod_regime;
                this.carga_horaria = carga_horaria;
                this.salario = salario;
                this.telefone = telefone;
                this.email = email;
                this.sexo = sexo;
                this.chefe = chefe;
                this.setorDepartamento = setorDepartamento;
        }




        public String getMatricula() {
                return matricula;
        }


        public void setMatricula(String matricula) {
                this.matricula = matricula;
        }


        public int getCod_regime() {
                return cod_regime;
        }


        public void setCod_regime(int cod_regime) {
                this.cod_regime = cod_regime;
        }


        public int getCarga_horaria() {
                return carga_horaria;
        }


        public void setCarga_horaria(int carga_horaria) {
                this.carga_horaria = carga_horaria;
        }


        public double getSalario() {
                return salario;
        }


        public void setSalario(double salario) {
                this.salario = salario;
        }


        public String getTelefone() {
                return telefone;
        }


        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }


        public String getEmail() {
                return email;
        }


        public void setEmail(String email) {
                this.email = email;
        }


        public String getSexo() {
                return sexo;
        }


        public void setSexo(String sexo) {
                this.sexo = sexo;
        }


        public boolean isChefe() {
                return chefe;
        }


        public void setChefe(boolean chefe) {
                this.chefe = chefe;
        }


        public SetorDepartamento getSetorDepartamento() {
                return setorDepartamento;
        }


        public void setSetorDepartamento(SetorDepartamento setorDepartamento) {
                this.setorDepartamento = setorDepartamento;
        }


        
       

        
}
