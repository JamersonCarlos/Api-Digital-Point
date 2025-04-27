package com.example.demo.VOs;

import java.util.List;

import com.example.demo.model.Funcionario;
import com.example.demo.model.LocaisTrabalho;

public class SetorDepartamentoVO {
        private Integer id; 
        private String nome; 
        private List<LocaisTrabalho> locaisTrabalhos;
        private List<Funcionario> funcionarios; 
        private Funcionario chefe;

        
        
        public SetorDepartamentoVO() {
        }

        public Integer getId() {
                return id;
        }
        public void setId(Integer id) {
                this.id = id;
        }
        public String getNome() {
                return nome;
        }
        public void setNome(String nome) {
                this.nome = nome;
        }
        public List<LocaisTrabalho> getLocaisTrabalhos() {
                return locaisTrabalhos;
        }
        public void setLocaisTrabalhos(List<LocaisTrabalho> locaisTrabalhos) {
                this.locaisTrabalhos = locaisTrabalhos;
        }

        public List<Funcionario> getFuncionarios() {
                return funcionarios;
        }

        public void setFuncionarios(List<Funcionario> funcionarios) {
                this.funcionarios = funcionarios;
        }

        public Funcionario getChefe() {
            return chefe;
        }

        public void setChefe(Funcionario chefe) {
            this.chefe = chefe;
        } 

        
        
}
