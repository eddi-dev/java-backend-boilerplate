package com.eddicorp.javabackendboilerplate.user.application.impl;

import com.eddicorp.javabackendboilerplate.appSupports.Assert;
import com.eddicorp.javabackendboilerplate.user.application.UserQueryService;
import com.eddicorp.javabackendboilerplate.user.application.UserSearchQuery;
import com.eddicorp.javabackendboilerplate.user.application.UserSearchQueryResult;
import com.eddicorp.javabackendboilerplate.user.application.exception.UserNotFoundException;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUser;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserId;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final BoilerplateUserRepository repository;

    @Override
    public UserSearchQueryResult query(UserSearchQuery query) {
        final BoilerplateUser user = repository.findById(BoilerplateUserId.from(query.getId()));
        Assert.mustNotBeNull(user, new UserNotFoundException("Unable to find user. Give id: " + query.getId()));
        return new UserSearchQueryResult(
                user.getEmail(),
                user.getDisplayName()
        );
    }
}
