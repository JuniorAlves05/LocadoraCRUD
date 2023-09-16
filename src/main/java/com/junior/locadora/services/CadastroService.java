package com.junior.locadora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.repository.CadastroRepository;

@Service
public class CadastroService {

    private final CadastroRepository repo;

    @Autowired
    public CadastroService(CadastroRepository repo) {
        this.repo = repo;
    }

    public List<Cadastro> findAll() {
        return repo.findAll();
    }

    public Cadastro criarCadastro(String nome, String descricao, double duracao, int idademin) {
        // Validar os campos de entrada (opcional)
        if (nome == null || descricao == null || duracao <= 0 || idademin < 0) {
            throw new IllegalArgumentException("Campos de entrada inválidos.");
        }

        Cadastro cadastro = new Cadastro(null, nome, descricao, duracao, idademin);
        return repo.save(cadastro);
    }
}
