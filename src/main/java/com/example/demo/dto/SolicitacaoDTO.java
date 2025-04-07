package com.example.demo.dto;

import java.time.LocalDateTime;

public record SolicitacaoDTO(boolean anulacao_ponto, boolean alterar_horario_entrada, boolean alterar_horario_saida, LocalDateTime novo_horario_entrada, LocalDateTime novo_horario_saida) {

}
