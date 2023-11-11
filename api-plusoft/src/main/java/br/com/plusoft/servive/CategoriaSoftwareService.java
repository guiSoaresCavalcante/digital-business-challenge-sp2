package br.com.plusoft.servive;

import br.com.plusoft.dto.*;
import br.com.plusoft.entity.CategoriaSoftwareEntity;
import br.com.plusoft.entity.UsuarioEntity;
import br.com.plusoft.repository.CategoriaSoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaSoftwareService {

    @Autowired
    CategoriaSoftwareRepository repository;

    public void cadastrar(CadastroCategoriaSoftwareDto categoriaDto) {
        repository.save(new CategoriaSoftwareEntity(categoriaDto));
    }

    public Page<ListarCategoriaSoftwareDto> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListarCategoriaSoftwareDto::new);
    }

    public Page<ListarCategoriaSoftwareDto> listarAtivosEInativos(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListarCategoriaSoftwareDto::new);
    }

    public void atualizar(AtualizarCategoriaSoftwareDto categoriaDto) {
        Optional<CategoriaSoftwareEntity> categoria = repository.findById(categoriaDto.id());
        if (categoria.isPresent()) {
            CategoriaSoftwareEntity categoriaAtualizada = categoria.get();
            if (categoriaDto.nome() != null) {
                categoriaAtualizada.setNome(categoriaDto.nome());
            }

            if (categoriaDto.descricao() != null) {
                categoriaAtualizada.setDescricao(categoriaDto.descricao());
            }
        } else {
            throw new IllegalArgumentException("Categoria não encontrada");
        }


    }


    public void deletar(Long id) {
        var categoria = repository.getReferenceById(id);
        if(categoria != null) {
            categoria.setAtivo(false);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }
}

