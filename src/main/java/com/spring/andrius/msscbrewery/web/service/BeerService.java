package com.spring.andrius.msscbrewery.web.service;

import com.spring.andrius.msscbrewery.web.model.BeerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerService {

    public BeerDto getBeerById(UUID beerId) {
        return  BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Corona")
                .beerStyle("Pale Ale")
                .build();
    }

    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
}
