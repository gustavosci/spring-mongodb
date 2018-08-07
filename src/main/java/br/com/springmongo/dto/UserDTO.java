package br.com.springmongo.dto;

import java.io.Serializable;

import br.com.springmongo.entity.User;

public class UserDTO implements Serializable{

    private static final long serialVersionUID = -6163519504259292155L;

    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(final User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
