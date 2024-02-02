package com.spring.andrius.msscbrewery.web.controller;

import com.spring.andrius.msscbrewery.web.model.BeerDto;
import com.spring.andrius.msscbrewery.web.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Deprecated
@RestController
@RequestMapping("/api/v1/beer/")
@AllArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeer(UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto) {
        BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity<BeerDto> updateBeer(UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
