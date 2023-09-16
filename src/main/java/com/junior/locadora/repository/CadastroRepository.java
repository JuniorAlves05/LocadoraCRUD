package com.junior.locadora.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.junior.locadora.domain.Cadastro;

@Repository
public interface CadastroRepository extends MongoRepository<Cadastro, String>{

}
