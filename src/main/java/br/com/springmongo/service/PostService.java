package br.com.springmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springmongo.entity.Post;
import br.com.springmongo.repository.PostRepository;
import br.com.springmongo.service.exception.ObjectNotFoundException;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(final String id) {
        return postRepository.findById(id).orElseThrow(() -> {
            return new ObjectNotFoundException("Post não encontrado");
        });
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public List<Post> findByTitle(final String text){
        return postRepository.findByTitleUsingQueryNative(text);
    }

    public List<Post> fullSearch(final String text, final Date minDate, final Date maxDate){
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}
