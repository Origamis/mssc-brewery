package com.spring.andrius.msscbrewery.web.service.v2;

import com.spring.andrius.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2 {

    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return null;
    }

    public void updateBeer(UUID beerId) {
        log.info("Beer is updated " + beerId);
    }

    public void deleteBeerById(UUID beerId) {
        log.info("Beer is deleted " + beerId);
    }
}
