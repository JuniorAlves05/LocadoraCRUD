package com.junior.locadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.dto.CadastroDTO;
import com.junior.locadora.repository.CadastroRepository;
import com.junior.locadora.services.exception.ObjectNotFoundException;

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
        
        public Cadastro findById(String id) {
            Optional<Cadastro> cadastroOptional = repo.findById(id);
            if (!cadastroOptional.isPresent()) {
                throw new ObjectNotFoundException("Cadastro não encontrado");
            }
            return cadastroOptional.get();
        }
        
        public Cadastro insert ( Cadastro obj) {
        	return repo.insert(obj);
        }

        public Cadastro fromDTO ( CadastroDTO objDto) {
        	return new Cadastro (objDto.getId(),objDto.getNome(),objDto.getDescricao(),objDto.getDuracao(),objDto.getIdademin());
        	
        	
        }
    }


