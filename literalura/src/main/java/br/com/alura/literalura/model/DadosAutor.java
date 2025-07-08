package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(@JsonAlias("name") String autor,
                        @JsonAlias("birth_year") String anoNascimento,
                        @JsonAlias("death_year") String anoFalecimento,
                        @JsonAlias("title") String livro) {

}
