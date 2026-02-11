package com.oliveiradev.gestao_fachadas.repository;

import com.oliveiradev.gestao_fachadas.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}
