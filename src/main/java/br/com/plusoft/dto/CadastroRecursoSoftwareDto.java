package br.com.plusoft.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroRecursoSoftwareDto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao
) {
}
