package com.example.demo.VOs;

import java.util.List;

public class DepartamentoVO {
        private int id;

        private String nome; 
        private String rua;
        private String bairro; 
        private String número; 
        private String complemento; 
        private String cep; 
        private String cidade;
        private int qtdSetores; 
        private List<SetorDepartamentoVO> setores;
        

        public DepartamentoVO() {
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

        public int getQtdSetores() {
                return qtdSetores;
        }

        public void setQtdSetores(int qtdSetores) {
                this.qtdSetores = qtdSetores;
        }

        public List<SetorDepartamentoVO> getSetores() {
                return setores;
        }

        public void setSetores(List<SetorDepartamentoVO> setores) {
                this.setores = setores;
        }

                

        
}
