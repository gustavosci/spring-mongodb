package br.com.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.springmongo.dto.AuthorDTO;
import br.com.springmongo.entity.Post;
import br.com.springmongo.entity.User;
import br.com.springmongo.repository.PostRepository;
import br.com.springmongo.repository.UserRepository;

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
        final Post post3 = new Post(null, sdf.parse("13/11/1993"), "LA 2018", "Vamos ser TRI", new AuthorDTO(dani));

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        gustavo.getPosts().addAll(Arrays.asList(post1));
        userRepository.save(gustavo);

        dani.getPosts().addAll(Arrays.asList(post2, post3));
        userRepository.save(dani);
    }
}
