package com.eddicorp.javabackendboilerplate.user.application;

public interface UserQueryService {

    UserSearchQueryResult query(UserSearchQuery query);
}
