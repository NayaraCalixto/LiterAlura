package br.com.alura.literalura.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosResultado {
    private List<DadosLivros> results;

    public List<DadosLivros> getResults() {
        return results;
    }

    public void setResults(List<DadosLivros> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "resultados=" + results +
                '}';
    }

}
