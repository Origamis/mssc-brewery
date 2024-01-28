package com.spring.andrius.msscbrewery.web.service;

import com.spring.andrius.msscbrewery.web.model.BeerDto;
import com.spring.andrius.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerService {
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Andrius Antipovas")
                .build();
    }

    public CustomerDto saveNewCustomer(CustomerDto beerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    public void updateCustomer(UUID customerId) {
        log.info("Customer is updated " + customerId);
    }

    public void deleteCustomerById(UUID customerId) {
        log.info("Customer is deleted " + customerId);
    }
}
