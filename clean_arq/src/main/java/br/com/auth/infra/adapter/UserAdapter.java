package br.com.auth.infra.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.auth.application.providers.UserProvider;
import br.com.auth.domain.User;
import br.com.auth.infra.entity.UserEntity;
import br.com.auth.infra.mapper.UserMapper;
import br.com.auth.infra.repository.JpaUserRepository;

@Repository
public class UserAdapter implements UserProvider {

    private final JpaUserRepository jpaUserRepository;

    public UserAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userEntity = jpaUserRepository.findByEmail(email);
        return userEntity.map(UserMapper::toDomain);
    }
}
