package br.com.plusoft.dto;

import br.com.plusoft.entity.CategoriaSoftwareEntity;

public record ListarCategoriaSoftwareDto(Long id, String nome, String descricao) {

    public ListarCategoriaSoftwareDto(CategoriaSoftwareEntity categoria) {
        this(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
