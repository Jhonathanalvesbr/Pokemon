package com.dio.pokemon.mapear;

import com.dio.pokemon.dto.PokemonDTO;
import com.dio.pokemon.entidade.Pokemon;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-03T01:40:00-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
public class PokemonMapearImpl implements PokemonMapear {

    @Override
    public Pokemon toModel(PokemonDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        Pokemon pokemon = new Pokemon();

        pokemon.setId( beerDTO.getId() );
        pokemon.setName( beerDTO.getName() );
        pokemon.setLevel( beerDTO.getLevel() );
        pokemon.setForca( beerDTO.getForca() );
        pokemon.setDefesa( beerDTO.getDefesa() );
        pokemon.setVida( beerDTO.getVida() );

        return pokemon;
    }

    @Override
    public PokemonDTO toDTO(Pokemon beer) {
        if ( beer == null ) {
            return null;
        }

        PokemonDTO pokemonDTO = new PokemonDTO();

        pokemonDTO.setId( beer.getId() );
        pokemonDTO.setName( beer.getName() );
        pokemonDTO.setLevel( beer.getLevel() );
        pokemonDTO.setForca( beer.getForca() );
        pokemonDTO.setDefesa( beer.getDefesa() );
        pokemonDTO.setVida( beer.getVida() );

        return pokemonDTO;
    }
}
