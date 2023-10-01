package br.com.plusoft.servive;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plusoft.dto.AtualizarUsuarioDto;
import br.com.plusoft.dto.CadastroUsuarioDto;
import br.com.plusoft.entity.UsuarioEntity;
import br.com.plusoft.repository.UsuarioRepository;

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

	public Optional<UsuarioEntity> findByEmailSenha(String email, String senha) {
		return repository.findByEmailAndSenha(email, senha);
	}

	public List<CadastroUsuarioDto> listarTodos() {
		List<UsuarioEntity> usuarios = repository.findAll();
		return usuarios.stream().map(this::mapToDto).collect(Collectors.toList());
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
		if (usuario != null) {
			usuario.setAtivo(false);
		} else {
			throw new IllegalArgumentException("Usuário não encontrado");
		}
	}

	private CadastroUsuarioDto mapToDto(UsuarioEntity entity) {
		return new CadastroUsuarioDto(entity.getNome(), entity.getEmail(), entity.getSenha());
	}

}
