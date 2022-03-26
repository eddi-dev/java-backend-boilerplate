package com.eddicorp.javabackendboilerplate.user.application.impl;

import com.eddicorp.javabackendboilerplate.user.application.UserQueryService;
import com.eddicorp.javabackendboilerplate.user.application.UserSearchQuery;
import com.eddicorp.javabackendboilerplate.user.application.UserSearchQueryResult;
import com.eddicorp.javabackendboilerplate.user.application.exception.UserNotFoundException;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUser;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserId;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("사용자 조회 서비스")
class UserQueryServiceImplTest {

    private BoilerplateUserRepository mockRepository;
    private UserQueryService sut;

    @BeforeEach
    void setUp() {
        mockRepository = mock(BoilerplateUserRepository.class);
        sut = new UserQueryServiceImpl(mockRepository);
    }

    @DisplayName("사용자가 존재하는 경우 테스트")
    @Test
    void testFindingExistingUser() {

        // given
        final String id = UUID.randomUUID().toString();
        final UserSearchQuery userSearchQuery = new UserSearchQuery(id);

        // stub
        final String email = "alpha@boilerplate.test";
        final String displayName = "name";
        final BoilerplateUser user = BoilerplateUser.createNewBoilerplateUser(
                email,
                displayName
        );
        when(mockRepository.findById(any(BoilerplateUserId.class))).thenReturn(user);

        // when
        final UserSearchQueryResult actual = sut.query(userSearchQuery);

        // then
        assertNotNull(actual);
        assertEquals(email, actual.getEmail());
        assertEquals(displayName, actual.getDisplayName());
    }

    @DisplayName("사용자가 존재하지 않는 경우 예외가 발생한다")
    @Test
    void test() {

        // given
        final String id = UUID.randomUUID().toString();
        final UserSearchQuery userSearchQuery = new UserSearchQuery(id);

        // stub
        when(mockRepository.findById(any(BoilerplateUserId.class))).thenReturn(null);

        // when & then
        assertThrows(
                UserNotFoundException.class,
                () -> sut.query(userSearchQuery)
        );
    }
}