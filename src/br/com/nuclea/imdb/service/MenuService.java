package br.com.nuclea.imdb.service;

import java.util.Scanner;

public class MenuService {

    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {

        int opcao;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
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
        System.out.println("Cadastrando Diretor");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void cadastrarAtor() {
        System.out.println("Cadastrando Ator");
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
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void listarFilmes() {
        System.out.println("Metodo ainda nao implementado.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void listarDiretores() {
        System.out.println("Metodo ainda nao implementado.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

    public static void listarAtores() {
        System.out.println("Metodo ainda nao implementado.");
        System.out.println("Pressione ENTER para retornar ao menu.");
        scanner.nextLine();
        menu();
    }

}
