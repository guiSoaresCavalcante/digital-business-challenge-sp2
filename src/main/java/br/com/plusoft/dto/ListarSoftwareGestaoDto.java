package br.com.plusoft.dto;

import br.com.plusoft.entity.SoftwareGestaoEntity;

public record ListarSoftwareGestaoDto(Long id, String nome, String descricao, String linkDownload) {
    public ListarSoftwareGestaoDto(SoftwareGestaoEntity software) {
        this(software.getId(), software.getNome(), software.getDescricao(), software.getLinkDownload());
    }
}
