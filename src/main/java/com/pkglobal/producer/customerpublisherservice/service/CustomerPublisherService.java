package com.pkglobal.producer.customerpublisherservice.service;

import com.pkglobal.producer.customerpublisherservice.domain.Customer;
import com.pkglobal.producer.customerpublisherservice.domain.CustomerSuccessResponse;
import com.pkglobal.producer.customerpublisherservice.exception.TokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPublisherService {

  @Autowired
  private KafkaSender kafkaSender;

  public CustomerSuccessResponse publishToKafka(Customer body, String authorization) {
    CustomerSuccessResponse customerSuccessResponse = new CustomerSuccessResponse();
    if (authorization.length() > 10) {
      kafkaSender.send(body.toString());
      customerSuccessResponse.setStatus("201");
      customerSuccessResponse.setMessage("published the message successfully to Kafka");
    } else {
      throw new TokenException(authorization);
    }
    return customerSuccessResponse;
  }
}
