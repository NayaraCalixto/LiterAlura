package br.com.alura.literalura.model;

import br.com.alura.literalura.DTO.DadosLivros;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Autores autor;
    private String idioma;
    private Double numeroDownloads;
    @ManyToOne
    private Autores autores;

    public Livros() {}

    public Livros(DadosLivros dadosLivros, Autores autores) {
        this.titulo = dadosLivros.titulo();
        this.autor = autores;
        this.idioma = dadosLivros.idioma().get(0);
        this.numeroDownloads = dadosLivros.numeroDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Double numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + 
                ", Autor: " + autor + 
                ", Idioma: " + idioma +
                ", Número de downloads: " + numeroDownloads;
    }

    
}




