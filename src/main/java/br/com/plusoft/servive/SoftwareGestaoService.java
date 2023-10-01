package br.com.plusoft.servive;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.plusoft.dto.AtualizarSoftwareGestaoDto;
import br.com.plusoft.dto.CadastroSoftwareGestaoDto;
import br.com.plusoft.dto.ListarSoftwareGestaoDto;
import br.com.plusoft.entity.SoftwareGestaoEntity;
import br.com.plusoft.repository.SoftwareGestaoRepository;

@Service
public class SoftwareGestaoService {

    @Autowired
    SoftwareGestaoRepository repository;

    public void cadastrar(CadastroSoftwareGestaoDto softwareGestaoDto) {
        repository.save(new SoftwareGestaoEntity(softwareGestaoDto));
    }

    public Page<ListarSoftwareGestaoDto> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListarSoftwareGestaoDto::new);
    }

    public Page<ListarSoftwareGestaoDto> listarAtivosEInativos(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListarSoftwareGestaoDto::new);
    }

    public void atualizar(AtualizarSoftwareGestaoDto softwareGestaoDto) {
        Optional<SoftwareGestaoEntity> softwareGestao = repository.findById(softwareGestaoDto.id());
        if (softwareGestao.isPresent()) {
            SoftwareGestaoEntity softwareGestaoAtualizado = softwareGestao.get();
            if (softwareGestaoDto.nome() != null) {
                softwareGestaoAtualizado.setNome(softwareGestaoDto.nome());
            }

            if (softwareGestaoDto.descricao() != null) {
                softwareGestaoAtualizado.setDescricao(softwareGestaoDto.descricao());
            }

            if (softwareGestaoDto.linkDownload() != null) {
                softwareGestaoAtualizado.setLinkDownload(softwareGestaoDto.linkDownload());
            }
        } else {
            throw new IllegalArgumentException("Software não encontrado");
        }


    }

    public void deletar(Long id) {
        var softwareGestao = repository.getReferenceById(id);
        if(softwareGestao != null) {
            softwareGestao.setAtivo(false);
        } else {
            throw new IllegalArgumentException("Software não encontrado");
        }
    }
}
