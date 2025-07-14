package br.com.alura.literalura.principal;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.literalura.DTO.DadosAutores;
import br.com.alura.literalura.DTO.DadosLivros;
import br.com.alura.literalura.DTO.DadosResultados;
import br.com.alura.literalura.model.Autores;
import br.com.alura.literalura.model.Livros;
import br.com.alura.literalura.repository.AutoresRepository;
import br.com.alura.literalura.repository.LivrosRepository;
import br.com.alura.literalura.service.ConsumoApi;
import br.com.alura.literalura.service.ConverteDados;

public class Principal {

    @Autowired
    private final LivrosRepository livrosRepository;

    @Autowired
    private final AutoresRepository autoresRepository;

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books?search=";
    private String json;

    public Principal(LivrosRepository livrosRepository, AutoresRepository autoresRepository) {
        this.livrosRepository = livrosRepository;
        this.autoresRepository = autoresRepository;
    }

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
                try {
                    
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
                leitura.nextLine();

                switch (opcao) {
                    case 1:
                        buscarLivroPorTitulo();
                        break;
                    case 2:
                        listarLivrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLivrosPorAno();
                        break;
                    default:
                        System.out.println("Digite uma opção válida.");
                        break;
                    }
                    
        }


    }

    private void buscarLivroPorTitulo() {
        DadosLivros dadosLivros = obterDadosLivro();
        if(dadosLivros != null) {
            DadosAutores dadosAutores = dadosLivros.autor().get(0);
            Livros livros;
            Autores autoresExistentes = autoresRepository.findByNome(dadosAutores.autor());
            if(autoresExistentes != null) {
               livros = new Livros(dadosLivros, autoresExistentes); 
            } else {
                Autores novosAutores = new Autores(dadosAutores);
                livros = new Livros(dadosLivros, novosAutores);
                autoresRepository.save(novosAutores);
            }
            try {
                livrosRepository.save(livros);
                System.out.println(livros);
            } catch (Exception e) {
                System.out.println("Livro já consta no banco de dados.");
            }
        }
    }

    // private void buscarLivroPorTitulo() {
    //     System.out.print("Digite o título do livro que você deseja buscar: ");
    //     String nomeLivro = leitura.nextLine(); 
        
    //     String url = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "%20").toLowerCase().trim());
    //     System.out.println(url);

    //     DadosLivros[] livros = converteDados.obterDados(json, DadosLivros[].class);

    //     if (livros.length == 0) {
    //         System.out.println("Nenhum livro encontrado para a pesquisa \"" + nomeLivro + "\".");
    //         return;
    //     }

    //     System.out.println("*** Lista de Livros ***");

    //     for (DadosLivros livro : livros) {
    //         System.out.println("Título: " + livro.titulo());
    //         System.out.println("Autor: " + livro.autor());
    //         System.out.println("Idioma: " + livro.idioma());
    //         System.out.println("Downloads: " + livro.numeroDownloads());
    //         System.out.println("-----------------------");
    //     }
    // }

    private DadosLivros obterDadosLivro() {
        System.out.print("Digite o título do livro que você deseja buscar: ");
        String nomeLivro = leitura.nextLine();
        json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "%20").trim());
        DadosResultados dadosBusca = converteDados.obterDados(json, DadosResultados.class);
        Optional<DadosLivros> dadosLivros = dadosBusca.resultados().stream()
                                                .filter(livro -> livro.titulo().toUpperCase().contains(nomeLivro.toUpperCase()))
                                                .findFirst();
        if (dadosLivros.isPresent()) {
            return dadosLivros.get();
        }
        else {
            return null;
        }
    }

    private void listarLivrosPorAno() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarLivrosPorAno'");
    }

    private void listarAutoresVivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarAutoresVivos'");
    }

    private void listarAutoresRegistrados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarAutoresRegistrados'");
    }

    private void listarLivrosRegistrados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarLivrosRegistrados'");
    }

}

