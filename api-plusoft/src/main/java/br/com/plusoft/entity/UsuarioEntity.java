package br.com.plusoft.entity;

import br.com.plusoft.dto.CadastroUsuarioDto;
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
    private String nome;

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

    @Column(name = "ATIVO", columnDefinition = "BIT")
    private boolean ativo;


    public UsuarioEntity(CadastroUsuarioDto dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.dataCadastro = LocalDate.now();
    }


}
