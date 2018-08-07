package br.com.springmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springmongo.entity.Post;
import br.com.springmongo.repository.PostRepository;
import br.com.springmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(final String id) {
        return postRepository.findById(id).orElseThrow(() -> {
            return new ObjectNotFoundException("Post não encontrado");
        });
    }
}
