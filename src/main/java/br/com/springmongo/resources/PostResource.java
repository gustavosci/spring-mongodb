package br.com.springmongo.resources;

import br.com.springmongo.resources.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.springmongo.entity.Post;
import br.com.springmongo.service.PostService;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> findAll() {
        return postService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post findById(@PathVariable String id) {
        return postService.findById(id);
    }

    @RequestMapping(value = "/search/title", method = RequestMethod.GET)
    public List<Post> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        final String textDecoded = URL.decodeParam(text);
        return postService.findByTitle(textDecoded);
    }
}
