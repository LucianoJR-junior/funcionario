package com.rh.funcionario.controller;

import com.rh.funcionario.model.Funcionario;
import com.rh.funcionario.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    /*
    criado os metodos HTTP
    @GetMapping	    GET	    Buscar dados
    @PostMapping	POST	Criar
    @PutMapping	    PUT	    Atualizar
    @DeleteMapping	DELETE	Remover
    */

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(service.atualizar(id,funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}