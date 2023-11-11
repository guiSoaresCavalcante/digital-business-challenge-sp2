package br.com.plusoft.dto;

import jakarta.validation.constraints.NotBlank;


public record CadastroSoftwareGestaoDto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String linkDownload
) {
}
