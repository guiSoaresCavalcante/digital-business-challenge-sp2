package br.com.plusoft.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDto(
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotBlank @Email
        String email,
        @NotBlank
        String senha

) {
}
