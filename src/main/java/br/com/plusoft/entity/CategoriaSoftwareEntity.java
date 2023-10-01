package br.com.plusoft.entity;

import java.util.List;

import br.com.plusoft.dto.CadastroCategoriaSoftwareDto;
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
@Table(name="CATEGORIA_SOFTWARE")
@Getter
@Setter
public class CategoriaSoftwareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID_CATEGORIA")
    private Long id;

    @Column(name="NM_CATEGORIA")
    private String nome;

    @Column(name="DESCRICAO_CATEGORIA")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<SoftwareGestaoEntity> softwares;

    @Column(name = "ATIVO", columnDefinition = "BIT")
    private boolean ativo;

    public CategoriaSoftwareEntity(CadastroCategoriaSoftwareDto categoriaDto) {
        this.nome = categoriaDto.nome();
        this.descricao = categoriaDto.descricao();
        this.ativo = true;
    }
    
    

	public CategoriaSoftwareEntity(Long id, String nome, String descricao, List<SoftwareGestaoEntity> softwares,
			boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.softwares = softwares;
		this.ativo = ativo;
	}

	
	


	public CategoriaSoftwareEntity() {
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
