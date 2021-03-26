package com.pkglobal.producer.customerpublisherservice.exception;

import com.pkglobal.producer.customerpublisherservice.domain.CustomerFailureResponse;
import com.pkglobal.producer.customerpublisherservice.util.ObjectMapperUtils;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomerPublisherControllerAdvice {

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<Object> handleTokenException(AuthenticationException ex, WebRequest request) {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("Token Error : " +ex.getMessage());
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

  @ExceptionHandler(ServletRequestBindingException.class)
  public ResponseEntity<Object> handleException(
      ServletRequestBindingException ex, HttpServletRequest request) {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("input headers are missing: "+ex.getMessage());
    customerFailureResponse.setStatus(HttpStatus.NOT_FOUND.toString());
    customerFailureResponse.setErrorType("Invalid Request Exception");
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(GeneralException.class)
  public ResponseEntity<CustomerFailureResponse> handleException(GeneralException ex, HttpServletRequest request) {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("General Error." + ex.getMessage());
    customerFailureResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    customerFailureResponse.setErrorType(GeneralException.class.getSimpleName());
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<CustomerFailureResponse> handleException(NoHandlerFoundException ex, HttpServletRequest request) {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("General Error. " + ex.getMessage());
    customerFailureResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    customerFailureResponse.setErrorType(GeneralException.class.getSimpleName());
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CustomerFailureResponse> handleException(MethodArgumentNotValidException ex, HttpServletRequest request) {
    Map<String, TreeSet<String>> fieldValidationError = new TreeMap<>();
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    for (FieldError fieldError : fieldErrors) {
      if (fieldValidationError.containsKey(fieldError.getField())) {
        TreeSet<String> error = fieldValidationError.get(fieldError.getField());
        error.add(fieldError.getDefaultMessage());
        fieldValidationError.put(fieldError.getField(), error);
      } else {
        TreeSet<String> error = new TreeSet<>();
        error.add(fieldError.getDefaultMessage());
        fieldValidationError.put(fieldError.getField(), error);
      }
    }
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("Input Request Validation Failed. " + ObjectMapperUtils.returnJsonFromObject(fieldValidationError));
    customerFailureResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    customerFailureResponse.setErrorType(InputMismatchException.class.getSimpleName());
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<CustomerFailureResponse> handleException(HttpMessageNotReadableException ex, HttpServletRequest request) {
    CustomerFailureResponse customerFailureResponse = new CustomerFailureResponse();
    customerFailureResponse.setMessage("Input Request Validation Failed. " + ex.getMessage());
    customerFailureResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
    customerFailureResponse.setErrorType(GeneralException.class.getSimpleName());
    return new ResponseEntity<>(customerFailureResponse, HttpStatus.BAD_REQUEST);
  }

}
