package com.dio.pokemon.mapear;

import com.dio.pokemon.dto.PokemonDTO;
import com.dio.pokemon.entidade.Pokemon;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonMapear {

    PokemonMapear INSTANCE = Mappers.getMapper(PokemonMapear.class);

    Pokemon toModel(PokemonDTO beerDTO);

    PokemonDTO toDTO(Pokemon beer);
}
