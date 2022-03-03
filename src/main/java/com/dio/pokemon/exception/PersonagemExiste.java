package com.dio.pokemon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonagemExiste extends Exception {
        public PersonagemExiste(String name) {

            super("Personagem já existe com esse nome: " + name);
        }
}


