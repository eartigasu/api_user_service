package com.example.userservice.exception;

public class InvalidInputException extends RuntimeException {
  public InvalidInputException(String message) {
    super(message);
  }
}
