package br.com.alura.literalura.model;

public class Autores {
    private Long id;
    private String nome;
    private String anoNascimento;
    private String anoFalecimento;
    private String livro;

    public Autores(Long id, String nome, String anoNascimento, String anoFalecimento, String livro) {
        this.id = id;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
        this.livro = livro;
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

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "Autor: " + nome + 
                ", Ano de nascimento: " + anoNascimento + 
                ", Ano falecimento: " + anoFalecimento + 
                ", Livros: " + livro;
    }

    
    
}


