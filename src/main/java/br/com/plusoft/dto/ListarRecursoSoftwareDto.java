package br.com.plusoft.dto;

import br.com.plusoft.entity.RecursoSoftwareEntity;

public record ListarRecursoSoftwareDto(Long id, String nome, String descricao) {

    public ListarRecursoSoftwareDto(RecursoSoftwareEntity recurso) {
        this(recurso.getId(), recurso.getNome(), recurso.getDescricao());
    }
}
