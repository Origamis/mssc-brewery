package com.spring.andrius.msscbrewery.web.mappers;

import com.spring.andrius.msscbrewery.domain.Customer;
import com.spring.andrius.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
