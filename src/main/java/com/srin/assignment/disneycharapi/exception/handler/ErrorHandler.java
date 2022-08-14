package com.srin.assignment.disneycharapi.exception.handler;

import com.srin.assignment.disneycharapi.enums.ResponseEnum;
import com.srin.assignment.disneycharapi.exception.CustomException;
import com.srin.assignment.disneycharapi.exception.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by oky.suryadi on 23/04/21.
 */
@RestControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> customException(CustomException e) {
    return ResponseEntity.status(e.getError().getStatus())
        .body(ErrorResponse.builder()
            .error(ErrorResponse.Error.builder()
                .code(e.getError().getCode())
                .message(Optional.ofNullable(e.getMessage())
                    .orElse(e.getError().getMessage()))
                .type(e.getError().getType())
                .build())
            .build());
  }
}
