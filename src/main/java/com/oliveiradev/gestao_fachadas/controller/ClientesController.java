package com.oliveiradev.gestao_fachadas.controller;

import com.oliveiradev.gestao_fachadas.dto.ClientesDto;
import com.oliveiradev.gestao_fachadas.model.Clientes;
import com.oliveiradev.gestao_fachadas.repository.ClientesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    ClientesRepository repository;

    @GetMapping
    public ResponseEntity vizualizarTodos() {
        List<Clientes> ListClientes = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ListClientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity vizualizarId(@PathVariable(value = "id") Integer id) {
        Optional<Clientes> cliente = repository.findById(id);
        if(cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(cliente.get());
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody ClientesDto dto) {
        var cliente = new Clientes();
        BeanUtils.copyProperties(dto, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable(value = "id") Integer id) {
        Optional<Clientes> cliente = repository.findById(id);
        if(cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        repository.delete(cliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable(value = "id") Integer id, @RequestBody ClientesDto dto) {
        Optional<Clientes> cliente = repository.findById(id);
        if(cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        var clienteModel = cliente.get();
        BeanUtils.copyProperties(dto, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(clienteModel));
    }
}
