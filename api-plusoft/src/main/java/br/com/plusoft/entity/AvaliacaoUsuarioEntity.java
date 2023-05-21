package br.com.plusoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="AVALIACOES_USUARIOS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_AVALIACAO")
    private Long id;

    @Column(name="NOTA_AVALIACAO")
    private Double nota;

    @Column(name="COMENTARIOS_USUARIO")
    private String comentario;

    @ManyToOne()
    @JoinColumn(name="ID_USUARIO")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "avaliacao")
    private List<SoftwareGestaoEntity> softwares;


}
