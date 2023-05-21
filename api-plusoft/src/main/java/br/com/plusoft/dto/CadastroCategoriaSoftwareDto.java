package br.com.plusoft.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroCategoriaSoftwareDto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao
) {
}
