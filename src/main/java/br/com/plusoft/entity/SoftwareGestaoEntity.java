package br.com.plusoft.entity;

import br.com.plusoft.dto.CadastroSoftwareGestaoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SOFTWARE_GESTAO")
@Getter
@Setter
public class SoftwareGestaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_SOFTWARE")
	private Long id;

	@Column(name = "NM_SOFTWARE")
	private String nome;

	@Column(name = "DESCRICAO_SOFTWARE")
	private String descricao;

	@Column(name = "LINK_DOWNLOAD")
	private String linkDownload;

	@ManyToOne
	@JoinColumn(name = "ID_RECURSOS")
	private RecursoSoftwareEntity recurso;

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA")
	private CategoriaSoftwareEntity categoria;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEntity usuario;

	@ManyToOne
	@JoinColumn(name = "ID_AVALIACAO")
	private AvaliacaoUsuarioEntity avaliacao;

	@Column(name = "ATIVO", columnDefinition = "BIT")
	private boolean ativo;

	public SoftwareGestaoEntity(CadastroSoftwareGestaoDto softwareGestaoDto) {
		this.nome = softwareGestaoDto.nome();
		this.descricao = softwareGestaoDto.descricao();
		this.linkDownload = softwareGestaoDto.linkDownload();
		this.ativo = true;
	}

	public SoftwareGestaoEntity(Long id, String nome, String descricao, String linkDownload,
			RecursoSoftwareEntity recurso, CategoriaSoftwareEntity categoria, UsuarioEntity usuario,
			AvaliacaoUsuarioEntity avaliacao, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.linkDownload = linkDownload;
		this.recurso = recurso;
		this.categoria = categoria;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.ativo = ativo;
	}

	public SoftwareGestaoEntity() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLinkDownload() {
		return linkDownload;
	}

	public void setLinkDownload(String linkDownload) {
		this.linkDownload = linkDownload;
	}

	public RecursoSoftwareEntity getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoSoftwareEntity recurso) {
		this.recurso = recurso;
	}

	public CategoriaSoftwareEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaSoftwareEntity categoria) {
		this.categoria = categoria;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public AvaliacaoUsuarioEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoUsuarioEntity avaliacao) {
		this.avaliacao = avaliacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
