package com.pkglobal.producer.customerpublisherservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkglobal.producer.customerpublisherservice.domain.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CustomerPublisher", description = "the publish API")
@RestController
@RequestMapping("/v1/customer")
public class CustomerPublisherController {

  private static final Logger log = LoggerFactory.getLogger(CustomerPublisherController.class);

  private ObjectMapper objectMapper;

  private HttpServletRequest request;

  @ApiOperation(
      value = "Publish Message to Kafka",
      nickname = "publishMessage",
      notes = "",
      tags = {
        "publish",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success Response"),
        @ApiResponse(code = 400, message = "Failure Response"),
        @ApiResponse(code = 401, message = "Failure Response"),
        @ApiResponse(code = 404, message = "Failure Response"),
        @ApiResponse(code = 500, message = "Failure Response")
      })
  @RequestMapping(
      value = "/publish",
      produces = {"application/xml", "application/json"},
      consumes = {"application/json", "application/xml"},
      method = RequestMethod.POST)
  ResponseEntity<Void> publishMessage(
      @ApiParam(value = "Consume the request and publish it to Kafka", required = true)
          @Validated
          @RequestBody
          Customer body) {
    String accept = request.getHeader("Accept");
    return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
  }
}
