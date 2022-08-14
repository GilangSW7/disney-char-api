package com.srin.assignment.disneycharapi.exception.handler;
import com.srin.assignment.disneycharapi.exception.CustomException;
import com.srin.assignment.disneycharapi.exception.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;


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
