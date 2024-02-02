package com.spring.andrius.msscbrewery.web.controller;

import com.spring.andrius.msscbrewery.web.model.BeerDto;
import com.spring.andrius.msscbrewery.web.model.CustomerDto;
import com.spring.andrius.msscbrewery.web.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomerDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedCustomerDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId);
    }

    @DeleteMapping("{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(UUID customerId) {
        customerService.deleteCustomerById(customerId);
    }
}
