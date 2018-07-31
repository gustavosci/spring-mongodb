package br.com.springmongo.config;

import br.com.springmongo.entity.User;
import br.com.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        final User gustavo = new User(null, "Gustavo", "gusta@g.com");
        final User dani = new User(null, "Maria", "maria@g.com");

        userRepository.saveAll(Arrays.asList(gustavo, dani));
    }
}
