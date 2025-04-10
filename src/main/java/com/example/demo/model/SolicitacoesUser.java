package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitacoes_user")
public class SolicitacoesUser {

        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id; 


        private boolean alterar_horario_entrada; 
        private boolean alterar_horario_saida; 
        private LocalDateTime novo_horario_entrada; 
        private LocalDateTime novo_horario_saida;
        private LocalDateTime created_at; 
        private LocalDateTime concluida_at;  

        
        @ManyToOne
        @JoinColumn(name = "id_ponto", referencedColumnName = "id")
        private HistoricoPontos historicoPontos; 
        

        @ManyToOne
        @JoinColumn(name = "user_login", referencedColumnName = "login")
        private User user;

        public SolicitacoesUser() {
        }

        public SolicitacoesUser(boolean alterar_horario_entrada, boolean alterar_horario_saida,
                        LocalDateTime novo_horario_entrada, LocalDateTime novo_horario_saida, User user, LocalDateTime created_at, HistoricoPontos historicoPontos) {
  
                this.alterar_horario_entrada = alterar_horario_entrada;
                this.alterar_horario_saida = alterar_horario_saida;
                this.novo_horario_entrada = novo_horario_entrada;
                this.novo_horario_saida = novo_horario_saida;
                this.historicoPontos = historicoPontos; 
                this.user = user;
                this.created_at = created_at; 
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

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
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

        public HistoricoPontos getHistoricoPontos() {
                return historicoPontos;
        }

        public void setHistoricoPontos(HistoricoPontos historicoPontos) {
                this.historicoPontos = historicoPontos;
        } 

        
        
        
}
