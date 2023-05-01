package br.com.plusoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="USUARIO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_USUARIO")
    private Long id;

    @Column(name="NM_USUARIO")
    private String name;

    @Column(name="SOBRENOME_USUARIO")
    private String sobrenome;

    @Column(name="EMAIL_USUARIO")
    private String email;

    @Column(name="SENHA_USUARIO")
    private String senha;

    @Column(name="DATA_CADASTRO")
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "usuario")
    private List<AvaliacaoUsuarioEntity> avaliacoes;

    @OneToMany(mappedBy = "usuario")
    private List<SoftwareGestaoEntity> softwares;


}
