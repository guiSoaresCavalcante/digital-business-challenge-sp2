package br.com.plusoft.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AVALIACOES_USUARIOS")
@Getter
@Setter
public class AvaliacaoUsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_AVALIACAO")
	private Long id;

	@Column(name = "NOTA_AVALIACAO")
	private Double nota;

	@Column(name = "COMENTARIOS_USUARIO")
	private String comentario;

	@ManyToOne()
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEntity usuario;

	@OneToMany(mappedBy = "avaliacao")
	private List<SoftwareGestaoEntity> softwares;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<SoftwareGestaoEntity> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<SoftwareGestaoEntity> softwares) {
		this.softwares = softwares;
	}

	public AvaliacaoUsuarioEntity(Long id, Double nota, String comentario, UsuarioEntity usuario,
			List<SoftwareGestaoEntity> softwares) {
		super();
		this.id = id;
		this.nota = nota;
		this.comentario = comentario;
		this.usuario = usuario;
		this.softwares = softwares;
	}

	public AvaliacaoUsuarioEntity() {
		super();

	}

}
