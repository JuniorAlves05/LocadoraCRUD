package com.junioralves.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junioralves.workshop.domain.Post;
import com.junioralves.workshop.repository.PostRepository;
import com.junioralves.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> optionalPost = repo.findById(id);
        return optionalPost.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searcheTitle(text); //  Chamada 
    }

    public List<Post> findAll() {
        return repo.findAll();
    }
}
