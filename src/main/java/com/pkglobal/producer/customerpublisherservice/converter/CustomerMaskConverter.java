package com.pkglobal.producer.customerpublisherservice.converter;

import com.pkglobal.producer.customerpublisherservice.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMaskConverter {

  public Customer customer;

  public Customer convert(Customer request) {

    customer = new Customer();

    if (!request.getCustomerNumber().isEmpty()) {
      String customerNumber = request.getCustomerNumber().substring(0, request.getCustomerNumber().length() - 4) + "****";
      customer.setCustomerNumber(customerNumber);
    }

    if (!request.getEmail().isEmpty()) {
      int length = request.getEmail().length();
      String email = "****"+request.getEmail().substring(4, length);
      customer.setEmail(email);
    }
    customer.setCustomerStatus(request.getCustomerStatus());
    customer.setAddress(request.getAddress());
    customer.setCountry(request.getCountry());
    customer.setCountryCode(request.getCountryCode());
    customer.setFirstName(request.getFirstName());
    customer.setLastname(request.getFirstName());
    customer.setMobileNumber(request.getMobileNumber());
    return customer;
  }
}
