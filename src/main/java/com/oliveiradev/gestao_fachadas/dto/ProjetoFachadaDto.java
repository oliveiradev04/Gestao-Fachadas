package com.oliveiradev.gestao_fachadas.dto;

import com.oliveiradev.gestao_fachadas.model.Clientes;

import java.time.LocalDate;

public record ProjetoFachadaDto(String nomeProjeto, String tipoFachada, LocalDate dataInicio, Integer clienteId) {
}
