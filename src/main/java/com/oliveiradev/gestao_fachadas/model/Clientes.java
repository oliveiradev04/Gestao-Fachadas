package com.oliveiradev.gestao_fachadas.model;

import jakarta.persistence.*;

@Entity (name = "clientes")
@Table (name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private String empresa;
    private String endereco;

    public Clientes() {
    }

    public Clientes(int id, String nome, String telefone, String empresa, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.empresa = empresa;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
