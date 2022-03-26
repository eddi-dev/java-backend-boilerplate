package com.eddicorp.javabackendboilerplate.test.fixture;

import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUser;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoilerplateUserBuilder {

    private BoilerplateUserId id;
    private String email;
    private String displayName;

    public static BoilerplateUserBuilder builder() {
        return new BoilerplateUserBuilder();
    }

    public BoilerplateUserBuilder id(String id) {
        this.id = BoilerplateUserId.from(id);
        return this;
    }

    public BoilerplateUserBuilder id() {
        this.id = BoilerplateUserId.createNewId();
        return this;
    }

    public BoilerplateUserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public BoilerplateUserBuilder email() {
        this.email = "user@test";
        return this;
    }

    public BoilerplateUserBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public BoilerplateUserBuilder displayName() {
        this.displayName = "tester";
        return this;
    }

    public BoilerplateUser build() {
        return BoilerplateUser.from(id.getValue(), email, displayName);
    }
}
