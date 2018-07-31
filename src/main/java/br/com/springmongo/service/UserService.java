package br.com.springmongo.service;

import br.com.springmongo.dto.UserDTO;
import br.com.springmongo.entity.User;
import br.com.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        final List<User> users = userRepository.findAll();
        final List<UserDTO> usersDTO = users.stream()
                .map(u -> new UserDTO(u.getName(), u.getEmail()))
                .collect(Collectors.toList());

        return usersDTO;
    }
}
