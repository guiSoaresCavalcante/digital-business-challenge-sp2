package br.com.plusoft.entity;

import br.com.plusoft.dto.CadastroSoftwareGestaoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SOFTWARE_GESTAO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SoftwareGestaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_SOFTWARE")
    private Long id;

    @Column(name="NM_SOFTWARE")
    private String nome;

    @Column(name="DESCRICAO_SOFTWARE")
    private String descricao;

    @Column(name="LINK_DOWNLOAD")
    private String linkDownload;

    @ManyToOne
    @JoinColumn(name="ID_RECURSOS")
    private RecursoSoftwareEntity recurso;

    @ManyToOne
    @JoinColumn(name="ID_CATEGORIA")
    private CategoriaSoftwareEntity categoria;

    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name="ID_AVALIACAO")
    private AvaliacaoUsuarioEntity avaliacao;

    @Column(name = "ATIVO", columnDefinition = "BIT")
    private boolean ativo;


    public SoftwareGestaoEntity(CadastroSoftwareGestaoDto softwareGestaoDto) {
        this.nome = softwareGestaoDto.nome();
        this.descricao = softwareGestaoDto.descricao();
        this.linkDownload = softwareGestaoDto.linkDownload();
        this.ativo = true;
    }

}
