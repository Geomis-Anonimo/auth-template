package br.com.auth.application.providers;

public interface HashProvider {
    /**
     * Verify a password against a hash.
     * @param rawPassword The raw password.
     * @param hashedValue The hashed password.
     * @return True if the password is correct, false otherwise.
     */
    boolean verify(String rawPassword, String hashedValue);
}