package com.spring.andrius.msscbrewery.web.controller;

import com.spring.andrius.msscbrewery.web.model.BeerDto;
import com.spring.andrius.msscbrewery.web.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@AllArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeer(UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerService.saveNewBeer(beerDto);
    }
}
