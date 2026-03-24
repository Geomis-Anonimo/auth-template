package messijr.auth.interfaces;

import java.util.Optional;

import messijr.auth.model.User;

public interface UserRepositoryInterface {
    public Optional<User> findByEmail(String email);
}
