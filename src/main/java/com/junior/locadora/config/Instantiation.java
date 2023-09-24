package com.junior.locadora.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.domain.Post;
import com.junior.locadora.domain.User;
import com.junior.locadora.repository.CadastroRepository;
import com.junior.locadora.repository.PostRepository;
import com.junior.locadora.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        // Limpar a coleção no MongoDB (opcional)
       //  cadastroRepository.deleteAll();
       
    	userRepository.deleteAll();
    	postRepository.deleteAll();
    	cadastroRepository.deleteAll();

        
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    	
    	Cadastro c1 = new Cadastro(null,"Tarzan","O rei da floresta",100,15,null);
    	Cadastro c2 = new Cadastro(null,"Rei Leao ","Teste rei leao",100,15,null);
       
        User joao = new User(null, "Joao", 10,"joao@gmail.com", null); 
        User maria = new User(null," Maria",15,"maria@gmail.com",null);
        
        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Esse filme e mto bom", null,joao,c1);
        Post post2 = new Post(null, sdf.parse("21/03/2018"),"Esse filme e mto bom", null,maria,c2);
   
         
        userRepository.saveAll(Arrays.asList(joao,maria));
        postRepository.saveAll(Arrays.asList(post1,post2));
        cadastroRepository.saveAll(Arrays.asList(c1,c2));
        
        // Salvar as instâncias no banco de dados
        //cadastroRepository.saveAll(Arrays.asList(c1, c2));
       // userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
