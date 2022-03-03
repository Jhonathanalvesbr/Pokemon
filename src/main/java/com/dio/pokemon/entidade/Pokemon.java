package com.dio.pokemon.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private double forca;

    @Column(nullable = false)
    private double defesa;

    @Column(nullable = false)
    private double vida;
}

