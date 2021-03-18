package com.pkglobal.producer.customerpublisherservice.controller;

import com.pkglobal.producer.customerpublisherservice.domain.Customer;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(value = "CustomerPublisher")
@RestController
@RequestMapping("/customer")
public class CustomerPublisherController {

    @PostMapping(value = "/publish")
    public void publishToKafka(@RequestBody Customer customer) {
        //we need to take the above json and send it to kafka
        System.out.println("Hello World!!!");
    }
}
