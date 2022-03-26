package com.eddicorp.javabackendboilerplate.user.application.impl;

import com.eddicorp.javabackendboilerplate.test.fixture.BoilerplateUserBuilder;
import com.eddicorp.javabackendboilerplate.user.application.UserSignUpCommand;
import com.eddicorp.javabackendboilerplate.user.application.UserSignUpResult;
import com.eddicorp.javabackendboilerplate.user.application.UserSignUpService;
import com.eddicorp.javabackendboilerplate.user.application.exception.UserAlreadyExistException;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUser;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("사용자 가입 서비스 테스트")
class UserSignUpServiceImplTest {

    private BoilerplateUserRepository mockRepository;
    private UserSignUpService sut;

    @BeforeEach
    void setUp() {
        mockRepository = mock(BoilerplateUserRepository.class);
        sut = new UserSignUpServiceImpl(mockRepository);
    }

    @DisplayName("이미 이메일이 존재하는 경우에 예외 발생")
    @Test
    void testExistingEmail() {

        // given
        final String email = "alpha@boilerplate.test";
        final String displayName = "name";
        final BoilerplateUser user = BoilerplateUser.createNewBoilerplateUser(
                email,
                displayName
        );

        // stub
        when(mockRepository.findByEmail(anyString()))
                .thenReturn(
                        BoilerplateUserBuilder
                                .builder()
                                .id()
                                .email(email)
                                .displayName(displayName)
                                .build()
                );

        assertThrows(
                UserAlreadyExistException.class,
                () -> sut.executeSignUp(new UserSignUpCommand(email, displayName))
        );
    }

    @DisplayName("새 사용자 가입 테스트")
    @Test
    void testNewUserSignUp() {
        // given
        final String email = "alpha@boilerplate.test";
        final String displayName = "name";
        final BoilerplateUser user = BoilerplateUser.createNewBoilerplateUser(
                email,
                displayName
        );

        // stub
        when(mockRepository.findByEmail(anyString())).thenReturn(null);
        when(mockRepository.save(any(BoilerplateUser.class))).thenReturn(user);

        // when
        final UserSignUpResult actual = sut.executeSignUp(new UserSignUpCommand(email, displayName));

        // then
        assertNotNull(actual);
    }
}