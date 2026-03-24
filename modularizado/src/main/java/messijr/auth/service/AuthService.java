package messijr.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import messijr.auth.exception.UserNotAuthenticatedException;
import messijr.auth.interfaces.UserRepositoryInterface;
import messijr.auth.model.User;
import messijr.auth.security.jwt.JwtService;

@Service
public class AuthService {

    private final UserRepositoryInterface userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
        UserRepositoryInterface userRepository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(
                () -> new UserNotAuthenticatedException()
            );

        String hashPassword = user.getPassword();

        if (!passwordEncoder.matches(password, hashPassword)) {
            throw new UserNotAuthenticatedException();
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                java.util.List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );

        String token = jwtService.generateToken(userDetails);

        return token;
    }
}
