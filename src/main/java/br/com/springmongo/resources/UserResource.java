package br.com.springmongo.resources;

import br.com.springmongo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        final User tst = new User(1, "Maria", "a@a.com");
        final User tst2 = new User(2, "Maria", "a@a.com");

        final List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(tst, tst2));

        return ResponseEntity.ok().body(users);
    }
}
