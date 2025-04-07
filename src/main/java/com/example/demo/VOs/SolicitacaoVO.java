package com.example.demo.VOs;

import java.time.LocalDateTime;

public class SolicitacaoVO {
        private int id; 
        private boolean anulacao_ponto; 
        private boolean alterar_horario_entrada; 
        private boolean alterar_horario_saida; 
        private LocalDateTime novo_horario_entrada; 
        private LocalDateTime novo_horario_saida;
        private LocalDateTime created_at;
        private LocalDateTime concluida_at;

               
        public SolicitacaoVO() {
        }
        public int getId() {
                return id;
        }
        public void setId(int id) {
                this.id = id;
        }
        public boolean isAnulacao_ponto() {
                return anulacao_ponto;
        }
        public void setAnulacao_ponto(boolean anulacao_ponto) {
                this.anulacao_ponto = anulacao_ponto;
        }
        public boolean isAlterar_horario_entrada() {
                return alterar_horario_entrada;
        }
        public void setAlterar_horario_entrada(boolean alterar_horario_entrada) {
                this.alterar_horario_entrada = alterar_horario_entrada;
        }
        public boolean isAlterar_horario_saida() {
                return alterar_horario_saida;
        }
        public void setAlterar_horario_saida(boolean alterar_horario_saida) {
                this.alterar_horario_saida = alterar_horario_saida;
        }
        public LocalDateTime getNovo_horario_entrada() {
                return novo_horario_entrada;
        }
        public void setNovo_horario_entrada(LocalDateTime novo_horario_entrada) {
                this.novo_horario_entrada = novo_horario_entrada;
        }
        public LocalDateTime getNovo_horario_saida() {
                return novo_horario_saida;
        }
        public void setNovo_horario_saida(LocalDateTime novo_horario_saida) {
                this.novo_horario_saida = novo_horario_saida;
        }
        public LocalDateTime getCreated_at() {
                return created_at;
        }
        public void setCreated_at(LocalDateTime created_at) {
                this.created_at = created_at;
        }
        public LocalDateTime getConcluida_at() {
                return concluida_at;
        }
        public void setConcluida_at(LocalDateTime concluida_at) {
                this.concluida_at = concluida_at;
        } 

        
}
