package com.junior.locadora.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CadastroDTO implements Serializable {
    
    public static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String descricao;
    private double duracao;
    private int idademin;
    private LocalDateTime dataHoraCadastro;

    public CadastroDTO() {
        // Construtor vazio
    }

    public CadastroDTO(String id, String nome, String descricao, double duracao, int idademin,
            LocalDateTime dataHoraCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.idademin = idademin;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getIdademin() {
        return idademin;
    }

    public void setIdademin(int idademin) {
        this.idademin = idademin;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }
}
