package com.srin.assignment.disneycharapi.exception;

import com.srin.assignment.disneycharapi.enums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {

    private final ResponseEnum error;
    private final String message;

    public CustomException(ResponseEnum error, String message) {
        super(message);
        this.error = error;
        this.message = message;
    }

    public CustomException(ResponseEnum error) {
        this(error, error.getMessage());
    }
}
