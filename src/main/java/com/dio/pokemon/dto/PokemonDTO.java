package com.dio.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {
    private long id;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    private int level;

    @NotNull
    private double forca;

    @NotNull
    private double defesa;

    @NotNull
    private double vida;


}
