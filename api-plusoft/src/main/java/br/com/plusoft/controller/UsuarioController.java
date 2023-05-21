package br.com.plusoft.controller;

import br.com.plusoft.dto.AtualizarUsuarioDto;
import br.com.plusoft.dto.CadastroUsuarioDto;
import br.com.plusoft.dto.ListarUsuarioDto;
import br.com.plusoft.servive.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroUsuarioDto usuario) {
        try {
            service.cadastrar(usuario);
            return ResponseEntity.created(URI.create("/" + usuario.nome())).body("Usuario Cadastrado");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<ListarUsuarioDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<ListarUsuarioDto>> listarAtivosEInativos(Pageable paginacao) {
        return ResponseEntity.ok(service.listarAtivosEInativos(paginacao));
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
