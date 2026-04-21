package br.com.nuclea.imdb.service;

import br.com.nuclea.imdb.filme.Filme;
import br.com.nuclea.imdb.pessoa.Diretor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuService {

    public static Scanner scanner = new Scanner(System.in);
    public static FilmeService filmeService = new FilmeService();
    public static DiretorService diretorService = new DiretorService();
    public static List<Diretor> diretorList = new ArrayList<Diretor>();

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

                case 0:
                    System.out.println("Encerrando sistema...");
                    //scanner.nextLine();
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    System.out.println("Pressione ENTER para retornar ao menu.");
                    scanner.nextLine();
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void cadastrarFilme() {
        Filme filme = filmeService.cadastrarFilme();
        filmeService.setfilmeSerive(filme);
        System.out.println("Cadastrando Filme");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

    public static void cadastrarDiretor() {
        Diretor diretor = diretorService.cadastrarDiretor();
        MenuService.diretorList.add(diretor);
        System.out.printf("O diretor %s foi criado com sucesso\n.", diretor.getNome());
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

    public static void cadastrarAtor() {
        System.out.println("Cadastrando Ator");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

    public static void associarDiretor() {
        System.out.println("Associando Diretor.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

    public static void associarAtor() {
        System.out.println("Associando Ator.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

    public static void listarFilmes() {
        filmeService.listarFilmes();
        System.out.println("Metodo ainda nao implementado.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

    public static void listarDiretores() {
        //System.out.println("Metodo ainda nao implementado.");
        diretorService.listarDiretor();
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }

    public static void listarAtores() {
        System.out.println("Metodo ainda nao implementado.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
    }
}
