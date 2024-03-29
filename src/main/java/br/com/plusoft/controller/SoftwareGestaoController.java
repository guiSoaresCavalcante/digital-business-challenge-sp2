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

import br.com.plusoft.dto.AtualizarSoftwareGestaoDto;
import br.com.plusoft.dto.CadastroSoftwareGestaoDto;
import br.com.plusoft.dto.ListarSoftwareGestaoDto;
import br.com.plusoft.servive.SoftwareGestaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwares")
public class SoftwareGestaoController {

    @Autowired
    SoftwareGestaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroSoftwareGestaoDto softwareGestaoDto) {
        try {
            service.cadastrar(softwareGestaoDto);
            return ResponseEntity.created(URI.create("/" + softwareGestaoDto.nome())).body("Software Cadastrado");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<ListarSoftwareGestaoDto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<ListarSoftwareGestaoDto>> listarAtivosEInativos(Pageable paginacao) {
        return ResponseEntity.ok(service.listarAtivosEInativos(paginacao));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid AtualizarSoftwareGestaoDto softwareGestaoDto) {
        try {
            service.atualizar(softwareGestaoDto);
            return ResponseEntity.ok("Software atualizado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Software não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Software deletado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Software não encontrado.");
        }
    }
}
