package br.com.plusoft.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plusoft.dto.AtualizarUsuarioDto;
import br.com.plusoft.dto.CadastroUsuarioDto;
import br.com.plusoft.entity.UsuarioEntity;
import br.com.plusoft.servive.UsuarioService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroUsuarioDto usuario) {
        try {
            service.cadastrar(usuario);
            return ResponseEntity.created(URI.create("/" + usuario.nome())).body("Usuario Cadastrado");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CadastroUsuarioDto loginRequest) {
        // Faça a validação e autenticação do usuário aqui, usando o serviço.
        // Aqui, você pode chamar o método findByEmailSenha do serviço.

        // Suponha que você recebe o email e a senha no objeto loginRequest.
        String email = loginRequest.email();
        String senha = loginRequest.senha();

        // Chame o serviço para verificar as credenciais do usuário.
        Optional<UsuarioEntity> usuario = service.findByEmailSenha(email, senha);

        if (usuario.isPresent()) {
            // Usuário autenticado com sucesso.
            // Você pode gerar um token de autenticação ou retornar o usuário, dependendo do seu caso de uso.
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            // Credenciais inválidas ou usuário não encontrado.
            return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
        }
    }
    
    

//    @GetMapping("/ativos")
//    public ResponseEntity<Page<ListarUsuarioDto>> listar(Pageable paginacao) {
//        return ResponseEntity.ok(service.listar(paginacao));
//    }

//    @GetMapping("/todos")
//    public ResponseEntity<Page<ListarUsuarioDto>> listarAtivosEInativos(Pageable paginacao) {
//        return ResponseEntity.ok(service.listarAtivosEInativos(paginacao));
//    }
    
    @GetMapping("/todos")
    public ResponseEntity<List<CadastroUsuarioDto>> listarAtivosEInativos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizarUsuarioDto usuarioDto) {
        try {
            service.atualizar(usuarioDto);
            return ResponseEntity.ok("Usuário atualizado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Usuário deletado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }
    }
}
