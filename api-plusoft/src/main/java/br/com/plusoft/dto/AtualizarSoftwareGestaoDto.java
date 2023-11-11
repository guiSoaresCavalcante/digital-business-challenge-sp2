package br.com.plusoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarSoftwareGestaoDto(
        @NotNull
        Long id,
        String nome,
        String descricao,
        String linkDownload
) {
}
