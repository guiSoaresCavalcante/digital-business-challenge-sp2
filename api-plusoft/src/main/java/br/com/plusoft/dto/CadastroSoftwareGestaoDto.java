package br.com.plusoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CadastroSoftwareGestaoDto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String linkDownload
) {
}
