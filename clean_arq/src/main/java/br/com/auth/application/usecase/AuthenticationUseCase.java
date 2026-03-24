package br.com.auth.application.usecase;

import org.springframework.stereotype.Service;

import br.com.auth.application.providers.HashProvider;
import br.com.auth.application.providers.UserProvider;
import br.com.auth.domain.User;
import br.com.auth.domain.exception.CustomException;


@Service
public class AuthenticationUseCase {
    private final UserProvider provider;
    private final HashProvider hashProvider;

    public AuthenticationUseCase(
        UserProvider provider,
        HashProvider hashProvider
    ) {
        this.provider = provider;
        this.hashProvider = hashProvider;
    }

    /**
     * Authenticate a user by email and password.
     * @param email The user's email.
     * @param password The user's password.
     * @return The authenticated user.
     * @throws CustomException If the user is not found or the password is incorrect.
     */
    public User execute(String email, String password) {
        User user = provider.findByEmail(email)
            .orElseThrow(() -> new CustomException(401, "Unauthorized"));

        if (!hashProvider.verify(password, user.getPassword())) {
            throw new CustomException(401, "Unauthorized");
        }

        return user;
    }
}
