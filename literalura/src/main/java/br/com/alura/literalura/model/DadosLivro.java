package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosLivro(@JsonAlias("title") String titulo, 
                        @JsonAlias("name") String autor,
                        @JsonAlias("languagues") String idioma,
                        @JsonAlias("download_count") String numeroDownloads) {

}
