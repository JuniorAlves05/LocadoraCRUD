package com.junioralves.workshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junioralves.workshop.domain.Post;
import com.junioralves.workshop.domain.User;
import com.junioralves.workshop.repository.PostRepository;
import com.junioralves.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> optionalUser = repo.findById(id);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

  
}
