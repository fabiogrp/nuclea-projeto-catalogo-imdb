package br.com.nuclea.imdb.service;

import br.com.nuclea.imdb.filme.Filme;
import br.com.nuclea.imdb.pessoa.Ator;
import br.com.nuclea.imdb.pessoa.Diretor;

import java.util.ArrayList;
import java.util.Scanner;


public class MenuService {

    public static Scanner scanner = new Scanner(System.in);
    public static AtorService atorService = new AtorService();
    public static DiretorService diretorService = new DiretorService();
    public static ArrayList<Diretor> diretorList = new ArrayList<Diretor>();
    public static FilmeService filmeService = new FilmeService();


    public static void menu() {
        int opcao;

        do {
            System.out.println("===== MENU PRINCIPAL =====\n");
            System.out.println("(1) - Cadastrar Filme");
            System.out.println("(2) - Cadastrar Diretor");
            System.out.println("(3) - Cadastrar Ator");
            System.out.println("(4) - Associar Diretor");
            System.out.println("(5) - Associar Ator");
            System.out.println("(6) - Listar Filmes");
            System.out.println("(7) - Listar Diretores");
            System.out.println("(8) - Listar Atores");
            System.out.println("(9) - Pesquisar Filme Por Nome");
            System.out.println("(0) - Sair");
            System.out.print("Escolha uma das opcoes do menu: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarFilme();
                    break;

                case 2:
                    cadastrarDiretor();
                    break;

                case 3:
                    cadastrarAtor();
                    break;

                case 4:
                    associarDiretor();
                    break;

                case 5:
                    associarAtor();
                    break;

                case 6:
                    listarFilmes();
                    break;

                case 7:
                    listarDiretores();
                    break;

                case 8:
                    listarAtores();
                    break;

                case 9:
                    pesquisarFilmeNome();
                    break;

                case 0:
                    scanner.close();
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    System.out.println("Pressione ENTER para retornar ao menu.");
                    scanner.nextLine();
                    menu();
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void cadastrarFilme() {
        System.out.println("Cadastrando Filme");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void cadastrarDiretor() {
        Diretor diretor = diretorService.cadastrarDiretor();
        MenuService.diretorList.add(diretor);
        System.out.printf("O diretor %s foi criado com sucesso\n.", diretor.getNome());
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();

        menu();
    }

    public static void cadastrarAtor() {
        System.out.println("Cadastrando Ator");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Cachê: ");
        Double cache = scanner.nextDouble();
        scanner.nextLine();

        Ator novoAtor = new Ator(nome, idade, cache);
        atorService.cadastrarAtor(novoAtor);
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void associarDiretor() {
        System.out.println("Associando Diretor.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void associarAtor() {
        System.out.println("Associando Ator.");
        System.out.print("Digite o nome do Filme: ");
        String nomeBuscaFilme = scanner.nextLine();
        Filme filmeEncontrado = filmeService.pesquisarFilmeNome(nomeBuscaFilme);

        if (filmeEncontrado == null) {
            System.out.println("Filme não encontrado!");
            return;
        }

        System.out.print("Digite o nome do Ator: ");
        String nomeBuscaAtor = scanner.nextLine();
        Ator atorEncontrado = atorService.buscarPorNome(nomeBuscaAtor);

        if (atorEncontrado != null) {
            filmeEncontrado.adicionarAtor(atorEncontrado);
            System.out.println("Ator vinculado ao filme com sucesso.");
        } else {
            System.out.println("Ator não encontrado no sistema.");
        }
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void listarFilmes() {
        filmeService.listarFilmes();
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void listarDiretores() {
        //System.out.println("Metodo ainda nao implementado.");
        diretorService.listarDiretor();
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void listarAtores() {
        System.out.println("Listandoa tores");
        AtorService.listarAtores();
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void pesquisarFilmeNome() {
        System.out.println("---PESQUISANDO FILME POR NOME---");
        System.out.println("Digite o nome do filme: ");
        String nomeFilme = scanner.nextLine();
        Filme filme = filmeService.pesquisarFilmeNome(nomeFilme);

        if (filme != null) {
            System.out.println("Filme encontrado:");
            System.out.println("------------------------------");
            System.out.println("Nome: " + filme.getNomeFilme() + " | Data de lançamento: "  + filme.getDataLancamento());
        } else {
            System.out.println("Filme não encontrado!");
        }
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

}
