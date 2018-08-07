package br.com.springmongo.service;

import br.com.springmongo.dto.UserDTO;
import br.com.springmongo.entity.User;
import br.com.springmongo.repository.UserRepository;
import br.com.springmongo.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDTO findById(final String id) {
        final User user = userRepository.findById(id).orElseThrow(() -> {
            return new ObjectNotFoundException("User não encontrado");
        });

        return new UserDTO(user);
    }
}
