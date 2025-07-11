package br.com.alura.literalura.principal;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.literalura.DTO.DadosLivros;
import br.com.alura.literalura.DTO.DadosResultado;
import br.com.alura.literalura.repository.AutoresRepository;
import br.com.alura.literalura.repository.LivrosRepository;
// import br.com.alura.literalura.model.Livros;
// import br.com.alura.literalura.repository.LivrosRepository;
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

    private DadosResultado getDadosLivro() {
        System.out.println("Insira o nome do livro que deseja procurar: ");
        var nomeLivro = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        if (json == null || json.isBlank()) {
            throw new RuntimeException("Resposta da API está vazia.");
        }
        DadosResultado resultado = converteDados.obterDados(json, DadosResultado.class);
        if (resultado.getResults().isEmpty()) {
            throw new RuntimeException("Nenhum livro encontrado para esse título.");
        }

        //return resultado.getResults().get(0); // pega o primeiro livro da lista
        return converteDados.obterDados(json, DadosResultado.class);
    
    }



    // private void buscarLivroPorTitulo() {
    //     DadosLivro livro = getDadosLivro();
    //     //Livros livros = new Livros(livro);
    //     List<Livros> salvarLivros = new ArrayList<>();
    //     System.out.println(salvarLivros);
    // }

}

