package com.eddicorp.javabackendboilerplate.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사용자 엔티티 테스트")
class BoilerplateUserTest {

    @DisplayName("기본 생성 규칙 테스트")
    @Test
    void testCreateNewUser() {

        // given
        final String email = "a@b.oilerplate";
        final String displayName = "tester";

        // when
        final BoilerplateUser user = BoilerplateUser.createNewBoilerplateUser(
                email,
                displayName
        );

        // then
        assertNotNull(user.getId());
        assertEquals(email, user.getEmail());
        assertEquals(displayName, user.getDisplayName());
    }
}
