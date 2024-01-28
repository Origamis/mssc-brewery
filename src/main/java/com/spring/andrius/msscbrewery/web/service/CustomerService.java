package com.spring.andrius.msscbrewery.web.service;

import com.spring.andrius.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Andrius Antipovas")
                .build();
    }
}
