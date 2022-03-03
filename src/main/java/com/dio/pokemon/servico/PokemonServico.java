package com.dio.pokemon.servico;

import com.dio.pokemon.dto.PokemonDTO;
import com.dio.pokemon.entidade.Pokemon;
import com.dio.pokemon.exception.PersonagemExiste;
import com.dio.pokemon.exception.PersonagemNaoExiste;
import com.dio.pokemon.mapear.PokemonMapear;
import com.dio.pokemon.repositorio.PokemonRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PokemonServico {

    private final PokemonRepositorio pokemonRepositorio;
    private final PokemonMapear pokemonMapear = PokemonMapear.INSTANCE;


    public PokemonDTO criarPokemon(PokemonDTO pokemonDTO) throws PersonagemExiste {
        procurarNome(pokemonDTO.getName());
        Pokemon pokemon = pokemonMapear.toModel(pokemonDTO);

        Pokemon salvar = pokemonRepositorio.save(pokemon);
        return pokemonMapear.toDTO(salvar);
    }

    public List<PokemonDTO> listAll(){
        return pokemonRepositorio.findAll()
                .stream()
                .map(pokemonMapear::toDTO)
                .collect(Collectors.toList());
    }

    public void procurarNome(String name) throws PersonagemExiste {
        Optional<Pokemon> achou = pokemonRepositorio.findByName(name);
        if(achou.isPresent()){
            throw new PersonagemExiste(name);
        }
    }

    public PokemonDTO procurarID(long id) throws PersonagemNaoExiste {
        Pokemon achou = pokemonRepositorio.findById(id)
                .orElseThrow(() -> new PersonagemNaoExiste(id));
        return pokemonMapear.toDTO(achou);
    }

    public void deletarId(long id) throws PersonagemNaoExiste {
        procurarID(id);
        pokemonRepositorio.deleteById(id);
    }

    public PokemonDTO atualizarId(long id, PokemonDTO pokemonDTO) throws PersonagemNaoExiste {
        PokemonDTO achou = procurarID(id);
        achou = pokemonDTO;
        pokemonRepositorio.save(pokemonMapear.toModel(achou));
        return pokemonDTO;
    }
}
