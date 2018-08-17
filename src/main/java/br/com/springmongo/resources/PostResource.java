package br.com.springmongo.resources;

import br.com.springmongo.resources.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.springmongo.entity.Post;
import br.com.springmongo.service.PostService;

import java.util.Date;
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

    @RequestMapping(value = "/search/full", method = RequestMethod.GET)
    public List<Post> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="mindate", defaultValue="") String minDate,
            @RequestParam(value="maxdate", defaultValue="") String maxDate) {
        final String textDecoded = URL.decodeParam(text);
        final Date minDateFormated = URL.convertDate(minDate, new Date(0));
        final Date maxDateFormated = URL.convertDate(maxDate, new Date());

        return postService.fullSearch(textDecoded, minDateFormated, maxDateFormated);
    }


    @RequestMapping(value = "/search/title", method = RequestMethod.GET)
    public List<Post> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        final String textDecoded = URL.decodeParam(text);
        return postService.findByTitle(textDecoded);
    }
}
