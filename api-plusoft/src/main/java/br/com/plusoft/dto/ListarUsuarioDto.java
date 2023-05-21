package br.com.plusoft.dto;

import br.com.plusoft.entity.UsuarioEntity;

public record ListarUsuarioDto(Long id, String nome, String sobrenome, String email) {

    public ListarUsuarioDto(UsuarioEntity usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getEmail());
    }
}
