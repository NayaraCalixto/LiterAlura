package br.com.alura.literalura.principal;

import java.util.Scanner;

import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.Livros;
import br.com.alura.literalura.repository.LivrosRepository;
import br.com.alura.literalura.service.ConsumoApi;
import br.com.alura.literalura.service.ConverteDados;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books?search=";
    private LivrosRepository repositorio;

    public void exibirMenu(){
        var opcao = -1;
        while(opcao != 0){
            var menu = """
                    ##################################################
                    Escolha o número de sua opção:

                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado ano

                    0 - Sair
                    """;

                    System.out.println(menu);
                    opcao = leitura.nextInt();
                    leitura.nextLine();

                    switch (opcao) {
                        case 1:
                            buscarLivroPorTitulo();
                            break;
                    
                        default:
                            break;
                    }
                    
        }


    }

    private DadosLivro getDadosLivro() {
        System.out.println("Insira o nome do livro que deseja procurar: ");
        var nomeLivro = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "+" ));
        DadosLivro livro = converteDados.obterDados(json, DadosLivro.class);
        return livro;
    }

    private void buscarLivroPorTitulo() {
        DadosLivro livro = getDadosLivro();
        Livros livros = new Livros(livro);
        repositorio.save(livros);
        System.out.println(livro);
    }

}

