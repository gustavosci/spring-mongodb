package br.com.springmongo.dto;

import java.io.Serializable;

import br.com.springmongo.entity.User;

public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 7187765877912756230L;
    
    private String id;
    private String name;

    public AuthorDTO(final User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
