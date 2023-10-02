package br.com.plusoft.entity;

import java.time.LocalDate;
import java.util.List;

import br.com.plusoft.dto.CadastroUsuarioDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_USUARIO")
	private Long id;

	@Column(name = "NM_USUARIO")
	private String nome;

	@Column(name = "SOBRENOME_USUARIO")
	private String sobrenome;

	@Column(name = "EMAIL_USUARIO")
	private String email;

	@Column(name = "SENHA_USUARIO")
	private String senha;

	@Column(name = "DATA_CADASTRO")
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
		this.email = dados.email();
		this.senha = dados.senha();
		this.dataCadastro = LocalDate.now();
	}

	public UsuarioEntity(Long id, String nome, String sobrenome, String email, String senha, LocalDate dataCadastro,
			List<AvaliacaoUsuarioEntity> avaliacoes, List<SoftwareGestaoEntity> softwares, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.avaliacoes = avaliacoes;
		this.softwares = softwares;
		this.ativo = ativo;
	}

	public UsuarioEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<AvaliacaoUsuarioEntity> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoUsuarioEntity> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<SoftwareGestaoEntity> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<SoftwareGestaoEntity> softwares) {
		this.softwares = softwares;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
