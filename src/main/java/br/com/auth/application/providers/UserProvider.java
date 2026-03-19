package br.com.auth.application.providers;

import java.util.Optional;

import br.com.auth.domain.User;

public interface UserProvider {
    Optional<User> findByEmail(String email);
}