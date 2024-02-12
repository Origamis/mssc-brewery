package com.spring.andrius.msscbrewery.web.mappers;

import com.spring.andrius.msscbrewery.domain.Beer;
import com.spring.andrius.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
