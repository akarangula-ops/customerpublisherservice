package com.pkglobal.producer.customerpublisherservice.controller;

import com.pkglobal.producer.customerpublisherservice.converter.CustomerMaskConverter;
import com.pkglobal.producer.customerpublisherservice.domain.Customer;
import com.pkglobal.producer.customerpublisherservice.domain.CustomerFailureResponse;
import com.pkglobal.producer.customerpublisherservice.domain.CustomerSuccessResponse;
import com.pkglobal.producer.customerpublisherservice.service.CustomerPublisherService;
import com.pkglobal.producer.customerpublisherservice.util.ObjectMapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CustomerPublisher", description = "the publish API")
@RestController
@Validated
@RequestMapping("/v1/customer")
public class CustomerPublisherController {

  private static final Logger log = LoggerFactory.getLogger(CustomerPublisherController.class);

  @Autowired
  private CustomerPublisherService customerPublisherService;

  @Autowired
  private CustomerMaskConverter customerMaskConverter;

  @ApiOperation(value = "Publish Message to Kafka", nickname = "publishMessage", notes = "", response = CustomerSuccessResponse.class,
      tags = {
        "publish",
      })
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "Success Response", response = CustomerSuccessResponse.class),
          @ApiResponse(code = 400, message = "Failure Response", response = CustomerFailureResponse.class),
          @ApiResponse(code = 401, message = "Failure Response", response = CustomerFailureResponse.class),
          @ApiResponse(code = 403, message = "Failure Response", response = CustomerFailureResponse.class),
          @ApiResponse(code = 404, message = "Failure Response", response = CustomerFailureResponse.class),
          @ApiResponse(code = 500, message = "Failure Response", response = CustomerFailureResponse.class)
      })
  @PostMapping(value = "/publish", produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<CustomerSuccessResponse> publishMessage(
          @RequestHeader(value = "Authorization", required = true) String authorization,
          @RequestHeader(value = "Activity-Id", required = true) String activityId,
          @RequestHeader(value = "Application-Id", required = true) String applicationId,
          @Valid @RequestBody Customer body) {
    String requestBody = ObjectMapperUtils.returnJsonFromObject(customerMaskConverter.convert(body));
    log.info("received the message the api : " + requestBody);
    CustomerSuccessResponse customerSuccessResponse = customerPublisherService.publishToKafka(ObjectMapperUtils.returnJsonFromObject(body), authorization);
    String customerResponseJson = ObjectMapperUtils.returnJsonFromObject(customerSuccessResponse);
    log.info("sending the response to api : " + customerResponseJson);
    return new ResponseEntity<>(customerSuccessResponse, HttpStatus.OK);
  }
}
