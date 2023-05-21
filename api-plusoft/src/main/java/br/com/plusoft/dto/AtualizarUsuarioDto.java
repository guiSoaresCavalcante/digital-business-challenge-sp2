package br.com.plusoft.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarUsuarioDto(
        @NotNull
        Long id,
        String nome,
        String sobrenome
) {
}
