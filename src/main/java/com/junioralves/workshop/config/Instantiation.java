package com.junioralves.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.junioralves.workshop.domain.User;
import com.junioralves.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository; // Repositório

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll(); // Vai limpar a coleção de dados no MongoDB

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User junior = new User(null,"Junior Alves","junioralves@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob)); // Salvando no banco de dados
    }
}
