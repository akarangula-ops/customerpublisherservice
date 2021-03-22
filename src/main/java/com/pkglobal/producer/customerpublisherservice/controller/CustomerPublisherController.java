package com.pkglobal.producer.customerpublisherservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkglobal.producer.customerpublisherservice.domain.Customer;
import com.pkglobal.producer.customerpublisherservice.domain.CustomerFailureResponse;
import com.pkglobal.producer.customerpublisherservice.domain.CustomerSuccessResponse;
import com.pkglobal.producer.customerpublisherservice.service.CustomerPublisherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

  @Autowired private CustomerPublisherService customerPublisherService;

  @ApiOperation(
      value = "Publish Message to Kafka",
      nickname = "publishMessage",
      notes = "",
      response = CustomerSuccessResponse.class,
      tags = {
        "publish",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 201,
            message = "Success Response",
            response = CustomerSuccessResponse.class),
        @ApiResponse(
            code = 400,
            message = "Failure Response",
            response = CustomerFailureResponse.class),
        @ApiResponse(
            code = 401,
            message = "Failure Response",
            response = CustomerFailureResponse.class),
        @ApiResponse(
            code = 403,
            message = "Failure Response",
            response = CustomerFailureResponse.class),
        @ApiResponse(
            code = 404,
            message = "Failure Response",
            response = CustomerFailureResponse.class),
        @ApiResponse(
            code = 500,
            message = "Failure Response",
            response = CustomerFailureResponse.class)
      })
  @RequestMapping(
      value = "/publish",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.POST)
  public ResponseEntity<CustomerSuccessResponse> publishMessage(
      @ApiParam(value = "Token for Authorization", required = true, defaultValue = "Authorization")
          @RequestHeader(value = "Authorization", required = true)
          String authorization,
      @ApiParam(
              value = "Unique Identifier for the request",
              required = true,
              defaultValue = "d7845679-4578-8972-7234-bg589374")
          @RequestHeader(value = "Activity-Id", required = true)
          String activityId,
      @ApiParam(value = "application Id", required = true, defaultValue = "customerProducerId")
          @RequestHeader(value = "Application-Id", required = true)
          String applicationId,
      @ApiParam(value = "Consume the request and publish it to Kafka", required = true)
          @Valid
          @RequestBody
          Customer body) {
    log.info("received the message the api : " + body);
    CustomerSuccessResponse customerSuccessResponse =
        customerPublisherService.publishToKafka(body, authorization);
    log.info("sending the response to api : " + customerSuccessResponse);
    return new ResponseEntity<CustomerSuccessResponse>(customerSuccessResponse, HttpStatus.CREATED);
  }
}
