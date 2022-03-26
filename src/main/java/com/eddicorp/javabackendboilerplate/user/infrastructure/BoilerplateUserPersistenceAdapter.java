package com.eddicorp.javabackendboilerplate.user.infrastructure;

import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUser;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserId;
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

    @Override
    public BoilerplateUser findById(BoilerplateUserId userId) {
        final BoilerplateUserEntity entity = repository.getByUid(userId.getValue());
        if (entity == null) {
            return null;
        }
        return BoilerplateUser.from(
                entity.getUid(),
                entity.getEmail(),
                entity.getDisplayName()
        );
    }

    @Override
    public BoilerplateUser findByEmail(String email) {
        final BoilerplateUserEntity entity = repository.getByEmail(email);
        if (entity == null) {
            return null;
        }
        return BoilerplateUser.from(
                entity.getUid(),
                entity.getEmail(),
                entity.getDisplayName()
        );
    }
}
