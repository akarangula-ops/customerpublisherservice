package com.pkglobal.producer.customerpublisherservice.exception;

public class TokenException extends RuntimeException {

  public TokenException(String tokenId) {
    super(String.format("Invalid Token %d", tokenId));
  }
}
