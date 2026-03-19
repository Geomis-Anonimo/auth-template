package br.com.auth.infra.mapper;

import br.com.auth.domain.Role;
import br.com.auth.domain.User;
import br.com.auth.infra.entity.UserEntity;

public class UserMapper {
    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                Role.valueOf(entity.getRole().name()),
                entity.isInactive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}