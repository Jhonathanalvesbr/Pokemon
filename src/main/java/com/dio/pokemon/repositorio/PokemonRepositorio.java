package com.dio.pokemon.repositorio;

import com.dio.pokemon.entidade.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface PokemonRepositorio extends JpaRepository<Pokemon, Long> {

    Optional<Pokemon> findByName(String name);

}
