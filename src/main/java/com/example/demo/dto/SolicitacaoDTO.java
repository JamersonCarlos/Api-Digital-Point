package com.example.demo.dto;

import java.time.LocalDateTime;

public record SolicitacaoDTO(int id_ponto, boolean anulacao_ponto, boolean alterar_horario_entrada, boolean alterar_horario_saida, LocalDateTime novo_horario_entrada, LocalDateTime novo_horario_saida) {

}
