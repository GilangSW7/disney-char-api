package com.srin.assignment.disneycharapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

  CHARACTER_NOT_FOUND(HttpStatus.BAD_REQUEST,
      "Character not found for characterId %s.",
      "invalid_request_error", HttpStatus.BAD_REQUEST.toString()),
  CHARACTER_ALREADY_EXIST(HttpStatus.BAD_REQUEST,
          "Character already exist for characterId %s.",
          "invalid_request_error", HttpStatus.BAD_REQUEST.toString()),
  DATA_NOT_EXIST(HttpStatus.BAD_REQUEST,
      "Data Not Exist",
      "invalid_request_error", HttpStatus.BAD_REQUEST.toString()),
  FAILED_DELETE_DATA(HttpStatus.BAD_REQUEST,
      "Delete character data is failed for characterId %s.",
      "invalid_request_error","category_not_found"),
  SUCCESS(HttpStatus.OK, "Success", "success", "0000");

  private final HttpStatus status;
  private final String message;
  private final String type;
  private final String code;
}
