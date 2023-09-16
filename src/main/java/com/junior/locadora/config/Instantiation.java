package com.junior.locadora.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.repository.CadastroRepository;

@Configuration // Informando ao Spring que essa é uma classe de configuração
public class Instantiation implements CommandLineRunner { // Serve para informar que estou planejando executar um codigo especifico  

	@Autowired
	private CadastroRepository cadastroRepository; // @Autowired para injetar uma instância de CadastroRepository
	
	@Override
	public void run(String... args) throws Exception {

	
	cadastroRepository.deleteAll(); // Serve para limpar a coleção no mongodb
		
	Cadastro c1 = new Cadastro(null,"Tarzan","O rei da floresta",123, 5);
	Cadastro c2 = new Cadastro(null,"Simba","O Leao brabo ",123,5);
	
	cadastroRepository.saveAll(Arrays.asList(c1,c2)); // Salva as instanciações no banco de dados.
	
	}

}
