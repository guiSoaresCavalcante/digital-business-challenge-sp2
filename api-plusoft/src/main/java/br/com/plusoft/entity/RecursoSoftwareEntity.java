package br.com.plusoft.entity;

import br.com.plusoft.dto.CadastroRecursoSoftwareDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="RECURSOS_SOFTWARE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecursoSoftwareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_RECURSOS")
    private Long id;

    @Column(name="NM_RECURSO")
    private String nome;

    @Column(name="DESCRICAO_RECURSO")
    private String descricao;

    @OneToMany(mappedBy = "recurso")
    private List<SoftwareGestaoEntity> softwares;

    @Column(name = "ATIVO", columnDefinition = "BIT")
    private boolean ativo;

    public RecursoSoftwareEntity(CadastroRecursoSoftwareDto recursoSoftwareDto) {
        this.ativo = true;
        this.nome = recursoSoftwareDto.nome();
        this.descricao = recursoSoftwareDto.descricao();
    }
}
