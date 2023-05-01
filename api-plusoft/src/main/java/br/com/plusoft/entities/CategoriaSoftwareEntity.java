package br.com.plusoft.entities;

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
    @Column(name="iD_CATEGORIA")
    private Long id;

    @Column(name="NM_CATEGORIA")
    private String nome;

    @Column(name="DESCRICAO_CATEGORIA")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<SoftwareGestaoEntity> softwares;
}
