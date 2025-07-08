package br.com.alura.literalura.model;

public class Livros {
    private Long id;
    private String titulo;
    private String autor;
    private String idioma;
    private String numeroDownloads;

    public Livros(Long id, String titulo, String autor, String idioma, String numeroDownloads) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numeroDownloads = numeroDownloads;
    }

    public Livros(DadosLivro livro) {
        //TODO Auto-generated constructor stub
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(String numeroDownloads) {
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




