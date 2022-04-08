package com.eddicorp.javabackendboilerplate.appSupports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Converter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String stringify(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ConverterException("stringify 중에 문제가 생겼어요: " + e.getMessage());
        }
    }
}
