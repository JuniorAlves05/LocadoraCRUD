package com.junioralves.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junioralves.workshop.domain.Post;
import com.junioralves.workshop.services.PostService;

@RestController // Recurso Rest
@RequestMapping(value = "/posts") // Caminho do End Point
public class PostResource { // Controlador Rest Acessa o Serviço

    @Autowired
    private PostService service; // O Serviço Acessa o Repositório

    @GetMapping(value = "/{id}") // Método Get
    public ResponseEntity<Post> findById(@PathVariable String id) { // PathVariable > Id casa com id recebido na url
        Post obj = service.findById(id); // Instanciando o objeto Post recebendo o service (PostService)
        return ResponseEntity.ok().body(obj); // Conversão do Post para ResponseEntity com corpo do objeto Post
    }

    @GetMapping // Método Get para listar todos os posts
    public ResponseEntity<List<Post>> findAll() {
        List<Post> list = service.findAll(); // Busca todos os posts e guarda na lista
        return ResponseEntity.ok().body(list); // Conversão da lista de posts para ResponseEntity
    }
}
