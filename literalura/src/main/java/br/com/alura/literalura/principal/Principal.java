package br.com.alura.literalura.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
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
    private List<Autores> autores = new ArrayList<>();
    private List<Livros> livros = new ArrayList<>();
    private String json;

    public Principal(LivrosRepository livrosRepository, AutoresRepository autoresRepository) {
        this.livrosRepository = livrosRepository;
        this.autoresRepository = autoresRepository;
    }

    public void exibirMenu() {
        var opcao = -1;
        while (opcao != 0) {
            try {
                var menu = """
                        \n##################################################
                        Escolha o número de sua opção:

                        1 - Buscar livro pelo título
                        2 - Listar livros registrados
                        3 - Listar autores registrados
                        4 - Listar autores vivos em um determinado ano
                        5 - Listar livros em um determinado idioma

                        0 - Sair
                        """ + "\n";

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
                        listarAutoresVivosPorAno();
                        break;
                    case 5:
                        listarLivrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Até logo.....");
                        break;
                    default:
                        System.out.println("Digite uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                leitura.nextLine();
            }

        }

    }

    private void buscarLivroPorTitulo() {
        DadosLivros dadosLivros = obterDadosLivro();
        if (dadosLivros != null) {
            DadosAutores dadosAutores = dadosLivros.autor().get(0);
            Livros livros;
            String nomeAutor = dadosAutores.autor().trim().toLowerCase();
            Autores autoresExistentes = autoresRepository.findByNomeIgnoreCase(nomeAutor);
            if (autoresExistentes != null) {
                livros = new Livros(dadosLivros, autoresExistentes);
            } else {
                Autores novosAutores = new Autores(dadosAutores);
                autoresRepository.save(novosAutores);
                livros = new Livros(dadosLivros, novosAutores);
            }
            try {
                livrosRepository.save(livros);
                System.out.println(livros);
            } catch (Exception e) {
                System.out.println("Livro já consta no banco de dados.");
            }
        } else {
            System.out.println("Livro não encontrado. Tente outro título.");
        }
    }

    private DadosLivros obterDadosLivro() {
        System.out.print("Digite o título do livro que você deseja buscar: ");
        String nomeLivro = leitura.nextLine().toLowerCase();
        json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "%20").trim());
        String[] palavrasChave = nomeLivro.split(" ");
        DadosResultados dadosBusca = converteDados.obterDados(json, DadosResultados.class);
        Optional<DadosLivros> dadosLivros = dadosBusca.resultados().stream()
                .filter(livro -> {
                    String titulo = livro.titulo();
                    if (titulo == null)
                        return false;
                    String tituloNormalizado = titulo.toLowerCase();
                    return Arrays.stream(palavrasChave)
                            .allMatch(tituloNormalizado::contains);
                })
                .findFirst();
        if (dadosLivros.isPresent()) {
            return dadosLivros.get();
        } else {
            return null;
        }
    }

    private void listarLivrosRegistrados() {
        livros = livrosRepository.findAll();
        livros.stream()
                .sorted(Comparator.comparing(Livros::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        autores = autoresRepository.findAll();
        autores.stream()
                .sorted(Comparator.comparing(Autores::getNome, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Digite o ano que deseja buscar:");
        try {
            String anoNascimento = leitura.nextLine();
            List<Autores> autores = autoresRepository.findByAnoNascimento(anoNascimento);

            if (autores.isEmpty()) {
                System.out.println("Nenhum autor encontrado para o ano " + anoNascimento);
            } else {
                autores.forEach(System.out::println);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ano inválido. Digite novamente.");
            leitura.nextLine();
        }

    }

    private void listarLivrosPorIdioma() {
        try {
            var menuIdiomas = """
                ##################################################
                Insira o idioma para realizar a busca(ex: es, en, fr, pt):

                ES - Espanhol
                EN - Inglês
                FR - Francês
                PT - Português

                \n""";

            System.out.println(menuIdiomas);
            String idioma = leitura.nextLine().trim().toLowerCase();

            List<Livros> livros = livrosRepository.findByIdiomaIgnoreCase(idioma);

            if (livros.isEmpty()) {
                System.out.println("Nenhum livro encontrado para o idioma.");
            } else {
                livros.forEach(System.out::println);
            }

        } catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida.");
        }
        
    }

}
