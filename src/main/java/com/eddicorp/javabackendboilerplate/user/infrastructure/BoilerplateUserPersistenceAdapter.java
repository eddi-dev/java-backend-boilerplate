package com.eddicorp.javabackendboilerplate.user.infrastructure;

import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUser;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoilerplateUserPersistenceAdapter implements BoilerplateUserRepository {

    private final BoilerplateUserEntityJpaRepository repository;

    @Override
    public BoilerplateUser save(BoilerplateUser user) {

        final BoilerplateUserEntity newEntity = new BoilerplateUserEntity(
                null,
                user.getId().getValue(),
                user.getEmail(),
                user.getDisplayName()
        );
        repository.save(newEntity);
        return user;
    }
}