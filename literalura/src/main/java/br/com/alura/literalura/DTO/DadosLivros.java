package br.com.alura.literalura.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivros(@JsonAlias("title") String titulo, 
                        @JsonAlias("authors") List<DadosAutores> autor,
                        @JsonAlias("languagues") List<String> idioma,
                        @JsonAlias("download_count") Double numeroDownloads) {

}
