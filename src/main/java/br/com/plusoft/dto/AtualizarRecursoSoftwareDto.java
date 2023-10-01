package br.com.plusoft.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarRecursoSoftwareDto(
        @NotNull
        Long id,
        String nome,
        String descricao
) {
}
