package model;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final int userId;
    private String email;
    private String password;
    private Role role;
    private String name;
    private String surname;

    public User(Integer userId, String email, String password, String name, String surname) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return userId;
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

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role && Objects.equals(name, user.name) && Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, role, name, surname);
    }
}
