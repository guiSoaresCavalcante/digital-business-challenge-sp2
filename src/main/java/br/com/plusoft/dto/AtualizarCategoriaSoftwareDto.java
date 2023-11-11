package br.com.plusoft.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarCategoriaSoftwareDto(
        @NotNull
        Long id,
        String nome,
        String descricao
) {
}
