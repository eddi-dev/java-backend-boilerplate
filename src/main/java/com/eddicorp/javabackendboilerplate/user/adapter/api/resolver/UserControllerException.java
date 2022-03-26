package com.eddicorp.javabackendboilerplate.user.adapter.api.resolver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserControllerException {
    private String code;
    private String message;
    private LocalDateTime timestamp;

    public UserControllerException(UserControllerErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getReasonPhrase();
        this.timestamp = LocalDateTime.now();
    }
}
