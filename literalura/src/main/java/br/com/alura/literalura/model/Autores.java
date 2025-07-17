package br.com.alura.literalura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.literalura.DTO.DadosAutores;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String anoNascimento;
    private String anoFalecimento;

    @OneToMany(mappedBy = "autores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livros> livros = new ArrayList<>();

    public Autores() {}

    public Autores(DadosAutores dadosAutores) {
        this.nome = String.valueOf(dadosAutores.autor());
        this.anoNascimento = String.valueOf(dadosAutores.anoNascimento());
        this.anoFalecimento = String.valueOf(dadosAutores.anoFalecimento());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(String anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    private List<String> getTitulosDosLivros() {
        return livros.stream()
                    .map(Livros::getTitulo)
                    .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "****************** Autor *********************\n" +
                "Autor: " + nome + "\n" +
                "Ano de nascimento: " + anoNascimento + "\n" +
                "Ano falecimento: " + anoFalecimento + "\n" +
                "Livros: " + getTitulosDosLivros() + "\n" +
                "**********************************************" + "\n";
    }

    
}




