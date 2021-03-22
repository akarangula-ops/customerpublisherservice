package com.pkglobal.producer.customerpublisherservice.service;

import com.pkglobal.producer.customerpublisherservice.domain.Customer;
import com.pkglobal.producer.customerpublisherservice.domain.CustomerSuccessResponse;
import com.pkglobal.producer.customerpublisherservice.exception.TokenException;
import org.springframework.stereotype.Service;

@Service
public class CustomerPublisherService {

  public CustomerSuccessResponse publishToKafka(Customer body, String authorization) {
    CustomerSuccessResponse customerSuccessResponse = new CustomerSuccessResponse();
    if (authorization.length() > 10) {
      customerSuccessResponse.setStatus("201");
      customerSuccessResponse.setMessage("published the message successfully to Kafka");
    } else {
      throw new TokenException(authorization);
    }
    return customerSuccessResponse;
  }
}
