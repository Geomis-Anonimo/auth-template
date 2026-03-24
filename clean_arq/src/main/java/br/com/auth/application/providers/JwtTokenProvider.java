package br.com.auth.application.providers;

import br.com.auth.domain.Role;
import br.com.auth.domain.User;

public interface JwtTokenProvider {
    String generate(User user);
    boolean isValid(String token);
    String getEmail(String token);
    Role getRole(String token);
}