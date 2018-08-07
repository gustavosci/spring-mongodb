package br.com.springmongo.config;

import br.com.springmongo.dto.AuthorDTO;
import br.com.springmongo.entity.Post;
import br.com.springmongo.entity.User;
import br.com.springmongo.repository.PostRepository;
import br.com.springmongo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        final User gustavo = new User(null, "Gustavo", "gusta@g.com");
        final User dani = new User(null, "Maria", "maria@g.com");

        userRepository.saveAll(Arrays.asList(gustavo, dani));

        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        final Post post1 = new Post(null, sdf.parse("27/10/1992"), "Partiu viagem", "Vamos a la playaa",
            new AuthorDTO(gustavo));
        final Post post2 = new Post(null, sdf.parse("13/11/1993"), "Vamo inter", "Rumo ao tetraa", new AuthorDTO(dani));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
