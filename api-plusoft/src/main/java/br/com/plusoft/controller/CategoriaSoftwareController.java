package br.com.plusoft.controller;

import br.com.plusoft.dto.*;
import br.com.plusoft.servive.CategoriaSoftwareService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaSoftwareController {

    @Autowired
    CategoriaSoftwareService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroCategoriaSoftwareDto categoriaDto) {
        try {
            service.cadastrar(categoriaDto);
            return ResponseEntity.created(URI.create("/" + categoriaDto.nome())).body("Categoria Cadastrada");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<ListarCategoriaSoftwareDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<ListarCategoriaSoftwareDto>> listarAtivosEInativos(Pageable paginacao) {
        return ResponseEntity.ok(service.listarAtivosEInativos(paginacao));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizarCategoriaSoftwareDto categoriaDto) {
        try {
            service.atualizar(categoriaDto);
            return ResponseEntity.ok("Categoria atualizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Categoria não encontrada");
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Categoria deletada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Categoria não encontrada.");
        }
    }
}
