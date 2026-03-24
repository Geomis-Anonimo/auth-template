package br.com.auth.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private boolean isInactive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {}

    public User(String email, Role role) {
        this.email = email;
        this.role = role;
    }

    public User(
        Long id,
        String name,
        String email,
        String password,
        Role role,
        boolean isInactive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isInactive = isInactive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}