package br.com.nuclea.imdb.service;

import br.com.nuclea.imdb.filme.Filme;
import br.com.nuclea.imdb.pessoa.Ator;
import br.com.nuclea.imdb.pessoa.Diretor;
import br.com.nuclea.imdb.repository.AtorMock;
import br.com.nuclea.imdb.repository.FilmeMock;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class MenuService {

    public static Scanner scanner = new Scanner(System.in);
    public static FilmeService filmeService = new FilmeService();
    public static DiretorService diretorService = new DiretorService();
    public static List<Diretor> diretorList = new ArrayList<Diretor>();
    public static AtorService atorService = new AtorService();

    static {
        AtorMock.getListaAtores();
        FilmeMock.getListaFilmes();
    }

    public static final String RESET = "\u001B[0m";
    public static final String CIANO = "\u001B[36m";
    public static final String AMARELO = "\u001B[33m";
    public static final String VERMELHO = "\u001B[31m";

    public static void menu() {
        int opcao;

        do {
            try {

                System.out.print(CIANO);
                System.out.println("===== CATÁLOGO DE FILMES - MENU PRINCIPAL =====\n");
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
                System.out.print("Escolha uma das opções do menu: ");

                System.out.print(RESET);
                System.out.print(AMARELO);
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
                        System.out.println("Encerrando sistema...");
                        break;

                    default:
                        System.out.println("Opcao invalida!");
                        System.out.println("Pressione ENTER para retornar ao menu");
                        scanner.nextLine();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(VERMELHO + "\nErro: Digite um número inteiro de 0 a 9!\n" + RESET);
                opcao = -1;
                scanner.nextLine();
            }
        } while (opcao != 0);
        System.out.print(RESET);
        scanner.close();
    }

    public static void cadastrarFilme() {
        System.out.println("---Cadastrando Filme---");
        Filme filme = filmeService.cadastrarFilme();
        filmeService.setfilmeService(filme);
        System.out.printf("\nFilme %s cadastrado com sucesso!\n", filme.getNomeFilme());
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void cadastrarDiretor() {
        System.out.println("---Cadastrando Diretor---");
        Diretor diretor = diretorService.cadastrarDiretor();
        MenuService.diretorList.add(diretor);
        System.out.printf("\nO(A) diretor(a) %s foi criado(a) com sucesso!\n", diretor.getNome());
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void cadastrarAtor() {
        System.out.println("---Cadastrando Ator---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Cache: ");
        Double cache = scanner.nextDouble();
        scanner.nextLine();

        Ator novoAtor = new Ator(nome, idade, cache);
        atorService.cadastrarAtor(novoAtor);
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void associarDiretor() {
        System.out.println("---Associando Diretor---");
        System.out.print("Digite o nome do Filme: ");
        String nomeBuscaFilme = scanner.nextLine();
        List<Filme> filmesEncontrados = filmeService.pesquisarFilmeNome(nomeBuscaFilme);

        if (!filmesEncontrados.isEmpty()) {
            System.out.println("Filme(s) encontrado(s):");
            for (int i = 0; i < filmesEncontrados.size(); i++) {
                System.out.println("ID: " + i + " | Nome: " + filmesEncontrados.get(i).getNomeFilme());
            }

            System.out.println("Selecione o filme para fazer a associação: ");
            int idFilmeBusca = scanner.nextInt();
            scanner.nextLine();

            if (idFilmeBusca >= 0 && idFilmeBusca < filmesEncontrados.size()) {
                Filme filmeEscolhido = filmesEncontrados.get(idFilmeBusca);
                System.out.print("Digite o nome do Diretor: ");
                String nomeBuscaDiretor = scanner.nextLine();
                Diretor diretorEncontrado = diretorService.buscarPorNome(nomeBuscaDiretor);

                if (diretorEncontrado != null) {
                    filmeEscolhido.setDiretorFilme(diretorEncontrado);
                    System.out.println("Diretor vinculado ao filme com sucesso!");
                } else {
                    System.out.println("Diretor não encontrado no sistema!");
                }

            } else {
                System.out.println("Opção inválida: id não encontado!");
            }

        } else {
            System.out.println("Não existe nenhum filme com esse nome: " + nomeBuscaFilme);
        }

        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void associarAtor() {
        System.out.println("---Associando Ator---");
        System.out.print("Digite o nome do Filme: ");
        String nomeBuscaFilme = scanner.nextLine();

        List<Filme> filmesEncontrados = filmeService.pesquisarFilmeNome(nomeBuscaFilme);

        if (!filmesEncontrados.isEmpty()) {
            for (int i = 0; i < filmesEncontrados.size(); i++) {
                System.out.println("Filme(s) encontrado(s):");
                System.out.println("ID: " + i + " | Nome: " + filmesEncontrados.get(i).getNomeFilme());
            }

            System.out.println("Selecione o filme para fazer a associação: ");
            int idFilmeBusca = scanner.nextInt();
            scanner.nextLine();

            if (idFilmeBusca >= 0 && idFilmeBusca < filmesEncontrados.size()) {
                Filme filmeEscolhido = filmesEncontrados.get(idFilmeBusca);

                System.out.print("Digite o nome do Ator: ");
                String nomeBuscaAtor = scanner.nextLine();
                Ator atorEncontrado = atorService.buscarPorNome(nomeBuscaAtor);

                if (atorEncontrado != null) {
                    filmeEscolhido.adicionarAtor(atorEncontrado);
                    System.out.println("Ator vinculado ao filme com sucesso!");
                } else {
                    System.out.println("Ator não encontrado no sistema!");
                }
            } else {
                System.out.println("Opção inválida: id não encontado!");
            }

        } else {
            System.out.println("Não existe nenhum filme com esse nome: " + nomeBuscaFilme);
        }
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void listarFilmes() {
        FilmeService.listarFilmes();
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void listarDiretores() {
        diretorService.listarDiretor();
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void listarAtores() {
        AtorService.listarAtores();
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

    public static void pesquisarFilmeNome() {
        System.out.println("---Pesquisando Filme Por Nome---");
        System.out.print("Digite o nome do filme: ");
        String nomeFilme = scanner.nextLine();

        List<Filme> filmesEncontrados = filmeService.pesquisarFilmeNome(nomeFilme);

        if (!filmesEncontrados.isEmpty()) {
            System.out.println("Filme(s) encontrado(s):");
            for (int i = 0; i < filmesEncontrados.size(); i++) {
                System.out.println("ID: " + i + " | Nome: " + filmesEncontrados.get(i).getNomeFilme());
            }
            System.out.println("Digite o ID do filme que deseja obter detalhes: ");
            int idFilmeBusca = scanner.nextInt();
            scanner.nextLine();
            if (idFilmeBusca >= 0 && idFilmeBusca < filmesEncontrados.size()) {
                filmeService.detalhesFilme(filmesEncontrados.get(idFilmeBusca));
            } else {
                System.out.println("Opção inválida!");
            }


        } else {
            System.out.println("Filme não encontrado!");
        }
        System.out.println("Pressione ENTER para retornar ao menu");
        scanner.nextLine();
    }

}
