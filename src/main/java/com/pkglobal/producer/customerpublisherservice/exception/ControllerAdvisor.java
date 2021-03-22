package com.pkglobal.producer.customerpublisherservice.exception;

import com.pkglobal.producer.customerpublisherservice.domain.CustomerFailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TokenException.class)
  public ResponseEntity<Object> handleTokenException(TokenException te, WebRequest request) {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("The Token supplied here is not valid!!");
    customerFailureResponse.setStatus(HttpStatus.UNAUTHORIZED.toString());
    customerFailureResponse.setErrorType("Token Exception");
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(InvalidRequestException.class)
  public ResponseEntity<Object> handleInvalidRequestException(
      InvalidRequestException ie, WebRequest request) {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("The request sent here is not valid!!");
    customerFailureResponse.setStatus(HttpStatus.NOT_FOUND.toString());
    customerFailureResponse.setErrorType("Invalid Request Exception");
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(GeneralException.class)
  public ResponseEntity<Object> handleGeneralException() {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("the Token supplied here is not valid!!");
    customerFailureResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    customerFailureResponse.setErrorType("General Exception");
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
