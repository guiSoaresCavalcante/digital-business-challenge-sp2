package br.com.plusoft.entity;

import br.com.plusoft.dto.CadastroCategoriaSoftwareDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="CATEGORIA_SOFTWARE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaSoftwareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_CATEGORIA")
    private Long id;

    @Column(name="NM_CATEGORIA")
    private String nome;

    @Column(name="DESCRICAO_CATEGORIA")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<SoftwareGestaoEntity> softwares;

    @Column(name = "ATIVO", columnDefinition = "BIT")
    private boolean ativo;

    public CategoriaSoftwareEntity(CadastroCategoriaSoftwareDto categoriaDto) {
        this.nome = categoriaDto.nome();
        this.descricao = categoriaDto.descricao();
        this.ativo = true;
    }
}
