package com.oliveiradev.gestao_fachadas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity (name = "projetofachada")
@Table (name = "projetofachada")
public class ProjetoFachada {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeProjeto;
    private String tipoFachada;
    private LocalDate dataInicio;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    public ProjetoFachada() {
    }

    public ProjetoFachada(int id, String nomeProjeto, String tipoFachada, LocalDate dataInicio, Clientes cliente) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
        this.tipoFachada = tipoFachada;
        this.dataInicio = dataInicio;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getTipoFachada() {
        return tipoFachada;
    }

    public void setTipoFachada(String tipoFachada) {
        this.tipoFachada = tipoFachada;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

}
