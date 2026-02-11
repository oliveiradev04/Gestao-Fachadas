package com.oliveiradev.gestao_fachadas.controller;

import com.oliveiradev.gestao_fachadas.dto.ClientesDto;
import com.oliveiradev.gestao_fachadas.dto.ProjetoFachadaDto;
import com.oliveiradev.gestao_fachadas.model.Clientes;
import com.oliveiradev.gestao_fachadas.model.ProjetoFachada;
import com.oliveiradev.gestao_fachadas.repository.ClientesRepository;
import com.oliveiradev.gestao_fachadas.repository.ProjetoFachadaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projeto-fachada")
public class ProjetoFachadaController {

    @Autowired
    ProjetoFachadaRepository repository;

    @GetMapping
    public ResponseEntity vizualizarTodos() {
        List<ProjetoFachada> ListProjetos = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ListProjetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity vizualizarId(@PathVariable(value = "id") Integer id) {
        Optional<ProjetoFachada> projeto = repository.findById(id);
        if (projeto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(projeto.get());
    }

    @Autowired
    ClientesRepository clientesRepository;

    @PostMapping
    public ResponseEntity criar(@RequestBody ProjetoFachadaDto dto) {

        var projeto = new ProjetoFachada();
        BeanUtils.copyProperties(dto, projeto);

        Clientes cliente = clientesRepository.findById(dto.clienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        projeto.setCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(projeto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable(value = "id") Integer id) {
        Optional<ProjetoFachada> projeto = repository.findById(id);
        if(projeto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado.");
        }
        repository.delete(projeto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Projeto deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable(value = "id") Integer id, @RequestBody ProjetoFachadaDto dto) {
        Optional<ProjetoFachada> projeto = repository.findById(id);
        if(projeto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado.");
        }
        var projetoModel = projeto.get();
        BeanUtils.copyProperties(dto, projetoModel);

        Clientes cliente = clientesRepository.findById(dto.clienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        projetoModel.setCliente(cliente);

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(projetoModel));
    }
}
