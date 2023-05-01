package br.com.plusoft.entities;

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

}
