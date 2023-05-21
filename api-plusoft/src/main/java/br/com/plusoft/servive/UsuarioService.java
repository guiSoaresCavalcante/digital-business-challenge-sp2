package br.com.plusoft.servive;

import br.com.plusoft.dto.AtualizarUsuarioDto;
import br.com.plusoft.dto.CadastroUsuarioDto;
import br.com.plusoft.dto.ListarUsuarioDto;
import br.com.plusoft.entity.UsuarioEntity;
import br.com.plusoft.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public void cadastrar(CadastroUsuarioDto usuarioDto) {
        if (repository.findByEmail(usuarioDto.email()) != null) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        repository.save(new UsuarioEntity(usuarioDto));
    }

    public Page<ListarUsuarioDto> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListarUsuarioDto::new);
    }

    public Page<ListarUsuarioDto> listarAtivosEInativos(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListarUsuarioDto::new);
    }

    public void atualizar(AtualizarUsuarioDto usuarioDto) {
        Optional<UsuarioEntity> usuario = repository.findById(usuarioDto.id());
        if (usuario.isPresent()) {
            UsuarioEntity usuarioAtualizado = usuario.get();
            if (usuarioDto.nome() != null) {
                usuarioAtualizado.setNome(usuarioDto.nome());
            }

            if (usuarioDto.sobrenome() != null) {
                usuarioAtualizado.setSobrenome(usuarioDto.sobrenome());
            }
        } else {
            throw new IllegalArgumentException("Usuário não encontrado");
        }


    }


    public void deletar(Long id) {
        var usuario = repository.getReferenceById(id);
        if(usuario != null) {
            usuario.setAtivo(false);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }
}
