package com.eddicorp.javabackendboilerplate.appSupports;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Assert {

    public void mustNotBeNull(Object obj, RuntimeException exception) {
        if (obj == null) {
            throw exception;
        }
    }

    public void mustBeNull(Object obj, RuntimeException exception) {
        if (obj != null) {
            throw exception;
        }
    }
}
