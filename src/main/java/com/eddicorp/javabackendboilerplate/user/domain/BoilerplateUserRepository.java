package com.eddicorp.javabackendboilerplate.user.domain;

public interface BoilerplateUserRepository {

    BoilerplateUser save(BoilerplateUser user);

    BoilerplateUser findById(BoilerplateUserId userId);

    BoilerplateUser findByEmail(String email);
}
