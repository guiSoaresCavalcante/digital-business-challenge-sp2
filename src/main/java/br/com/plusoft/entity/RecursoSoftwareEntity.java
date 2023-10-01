package br.com.plusoft.entity;

import java.util.List;

import br.com.plusoft.dto.CadastroRecursoSoftwareDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RECURSOS_SOFTWARE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecursoSoftwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_RECURSOS")
	private Long id;

	@Column(name = "NM_RECURSO")
	private String nome;

	@Column(name = "DESCRICAO_RECURSO")
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

	public RecursoSoftwareEntity(Long id, String nome, String descricao, List<SoftwareGestaoEntity> softwares,
			boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.softwares = softwares;
		this.ativo = ativo;
	}

	public RecursoSoftwareEntity() {
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
