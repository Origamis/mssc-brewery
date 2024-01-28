package com.spring.andrius.msscbrewery.web.service;

import com.spring.andrius.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerService {

    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
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

    public void updateBeer(UUID beerId) {
        log.info("Beer is updated " + beerId);
    }

    public void deleteBeerById(UUID beerId) {
        log.info("Beer is deleted " + beerId);
    }
}
