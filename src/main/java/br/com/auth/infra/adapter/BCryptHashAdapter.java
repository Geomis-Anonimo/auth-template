package br.com.auth.infra.adapter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.auth.application.providers.HashProvider;

@Component
public class BCryptHashAdapter implements HashProvider {
    private final PasswordEncoder passwordEncoder;

    public BCryptHashAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public boolean verify(String rawPassword, String hashedValue) {
        return passwordEncoder.matches(rawPassword, hashedValue);
    }
}
