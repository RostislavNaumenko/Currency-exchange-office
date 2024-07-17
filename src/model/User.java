package model;

import java.util.UUID;

public class User {
    private String id;
    private String email;
    private String password;
    private Role role;
    private String name;
    private String surname;

    public User(String email, String password, Role role, String name, String surname) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
