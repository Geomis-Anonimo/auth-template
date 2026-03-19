package br.com.auth.application.service;

import org.springframework.stereotype.Service;

import br.com.auth.application.providers.JwtTokenProvider;
import br.com.auth.application.usecase.AuthenticationUseCase;
import br.com.auth.domain.User;

@Service
public class AuthService {
    
    private final AuthenticationUseCase authenticationUseCase;
    private final JwtTokenProvider jwtTokenGenerator;

    public AuthService(
        AuthenticationUseCase authenticationUseCase,
        JwtTokenProvider jwtTokenGenerator
    ) {
        this.authenticationUseCase = authenticationUseCase;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    /**
     * Authenticate a user and generate a JWT token.
     * @param email The user's email.
     * @param password The user's password.
     * @return The JWT token.
     */
    public String authenticate(String email, String password) {
        User user = authenticationUseCase.execute(email, password);
        return jwtTokenGenerator.generate(user);
    }
}