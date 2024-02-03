package com.spring.andrius.msscbrewery.web.controller.v2;

import com.spring.andrius.msscbrewery.web.model.BeerDto;
import com.spring.andrius.msscbrewery.web.model.v2.BeerDtoV2;
import com.spring.andrius.msscbrewery.web.service.v2.BeerServiceV2;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
@AllArgsConstructor
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(UUID beerId) {
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedBeerDto = beerServiceV2.saveNewBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updateBeer(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(UUID beerId) {
        beerServiceV2.deleteBeerById(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationHandler(ConstraintViolationException ex) {
        List<String> errors = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
