package br.com.springmongo.resources;

import br.com.springmongo.dto.UserDTO;
import br.com.springmongo.entity.User;
import br.com.springmongo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO findById(@PathVariable String id) {
        return userService.findById(id);
    }

}
