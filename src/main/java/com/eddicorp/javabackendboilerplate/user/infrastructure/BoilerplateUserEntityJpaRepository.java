package com.eddicorp.javabackendboilerplate.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoilerplateUserEntityJpaRepository extends JpaRepository<BoilerplateUserEntity, Long> {
    BoilerplateUserEntity getByUid(String uid);
}
