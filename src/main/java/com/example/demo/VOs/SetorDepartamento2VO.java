package com.example.demo.VOs;

import java.util.List;

import com.example.demo.model.LocaisTrabalho;

public class SetorDepartamento2VO {
        private Integer id; 
        private String nome; 
        private List<LocaisTrabalho> locaisTrabalhos;

        public SetorDepartamento2VO() {
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

        
}
