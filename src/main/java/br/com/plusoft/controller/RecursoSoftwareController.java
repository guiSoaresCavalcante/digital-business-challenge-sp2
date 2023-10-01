package br.com.plusoft.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plusoft.dto.AtualizarRecursoSoftwareDto;
import br.com.plusoft.dto.CadastroRecursoSoftwareDto;
import br.com.plusoft.dto.ListarRecursoSoftwareDto;
import br.com.plusoft.servive.RecursoSoftwareService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/recursos")
public class RecursoSoftwareController {

    @Autowired
    private RecursoSoftwareService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroRecursoSoftwareDto recursoSoftwareDto) {
        try {
            service.cadastrar(recursoSoftwareDto);
            return ResponseEntity.created(URI.create("/" + recursoSoftwareDto.nome())).body("Recurso Cadastrado");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<ListarRecursoSoftwareDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<ListarRecursoSoftwareDto>> listarAtivosEInativos(Pageable paginacao) {
        return ResponseEntity.ok(service.listarAtivosEInativos(paginacao));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizarRecursoSoftwareDto recursoSoftwareDto) {
        try {
            service.atualizar(recursoSoftwareDto);
            return ResponseEntity.ok("Recurso atualizado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Recurso não encontrado");
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Recurso deletado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Recurso não encontrado.");
        }
    }
}
