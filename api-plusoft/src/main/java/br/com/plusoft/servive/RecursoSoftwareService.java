package br.com.plusoft.servive;

import br.com.plusoft.dto.*;
import br.com.plusoft.entity.RecursoSoftwareEntity;
import br.com.plusoft.repository.RecursoSoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecursoSoftwareService {

    @Autowired
    RecursoSoftwareRepository repository;

    public void cadastrar(CadastroRecursoSoftwareDto recursoSoftwareDto) {
        repository.save(new RecursoSoftwareEntity(recursoSoftwareDto));
    }

    public Page<ListarRecursoSoftwareDto> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListarRecursoSoftwareDto::new);
    }

    public Page<ListarRecursoSoftwareDto> listarAtivosEInativos(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListarRecursoSoftwareDto::new);
    }

    public void atualizar(AtualizarRecursoSoftwareDto recursoSoftwareDto) {
        Optional<RecursoSoftwareEntity> recursoSoftware = repository.findById(recursoSoftwareDto.id());
        if (recursoSoftware.isPresent()) {
            RecursoSoftwareEntity recursoSoftwareAtualizado = recursoSoftware.get();
            if (recursoSoftwareDto.nome() != null) {
                recursoSoftwareAtualizado.setNome(recursoSoftwareDto.nome());
            }

            if (recursoSoftwareDto.descricao() != null) {
                recursoSoftwareAtualizado.setDescricao(recursoSoftwareDto.descricao());
            }

        } else {
            throw new IllegalArgumentException("Recurso não encontrado");
        }


    }

    public void deletar(Long id) {
        var recursoSoftware = repository.getReferenceById(id);
        if(recursoSoftware != null) {
            recursoSoftware.setAtivo(false);
        } else {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }
}
