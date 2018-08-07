package br.com.springmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springmongo.dto.UserDTO;
import br.com.springmongo.entity.Post;
import br.com.springmongo.entity.User;
import br.com.springmongo.repository.UserRepository;
import br.com.springmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDTO findById(final String id) {
        return new UserDTO(findUserById(id));
    }

    public void delete(final String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public void insert(final UserDTO user) {
        userRepository.insert(fromDTO(user));
    }

    public void update(final User newUser) {
        userRepository.save(newUser);
    }

    public List<Post> findPostsById(final String id) {
        return findUserById(id).getPosts();
    }

    private User findUserById(final String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            return new ObjectNotFoundException("User não encontrado");
        });
    }

    private User fromDTO(final UserDTO dto) {
        return new User(null, dto.getName(), dto.getEmail());
    }
}
