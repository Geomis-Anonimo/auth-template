package messijr.auth.implementations;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import messijr.auth.interfaces.UserRepositoryInterface;
import messijr.auth.model.User;
import messijr.auth.repository.UserRepository;

@Repository
public class UserRepositoryImplementation implements UserRepositoryInterface {

    private final UserRepository userRepository;

    public UserRepositoryImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
