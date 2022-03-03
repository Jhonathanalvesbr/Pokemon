package com.dio.pokemon.contrrolador;

import com.dio.pokemon.dto.PokemonDTO;
import com.dio.pokemon.exception.PersonagemExiste;
import com.dio.pokemon.exception.PersonagemNaoExiste;
import com.dio.pokemon.servico.PokemonServico;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Controlador {

    private final PokemonServico pokemonServico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDTO criarPokemon(@RequestBody @Valid PokemonDTO pokemon) throws PersonagemExiste {
        return pokemonServico.criarPokemon(pokemon);
    }


    @GetMapping
    public List<PokemonDTO> listaMercado(){
        return pokemonServico.listAll();
    }

    @GetMapping("/{id}")
    public PokemonDTO procruarPokemon(@PathVariable long id) throws PersonagemNaoExiste {
       return pokemonServico.procurarID(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarId(@PathVariable Integer id) throws PersonagemNaoExiste {
        pokemonServico.deletarId(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDTO atualizarId(@PathVariable Integer id, @RequestBody @Valid PokemonDTO pokemonDTO) throws PersonagemNaoExiste {
        return pokemonServico.atualizarId(id, pokemonDTO);
    }

}