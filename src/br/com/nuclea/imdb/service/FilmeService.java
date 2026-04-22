package br.com.nuclea.imdb.service;

import br.com.nuclea.imdb.filme.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmeService {

    private List<Filme> filmeList;

    FilmeService() {
        this.filmeList = new ArrayList<Filme>();
    }

    public Filme cadastrarFilme() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do filme: ");
        String nomeFilme = scanner.nextLine();

        System.out.print("Informe o descricao do filme: ");
        String descricaoFilme = scanner.nextLine();

        System.out.print("Informe a data do lançamento do filme: ");
        String dataFilme = scanner.nextLine();

//        scanner.nextLine();

        System.out.print("Informe o orcamento do filme: ");
        double orcamento = scanner.nextDouble();

        //scanner.close();pesquisarFilmeNome

        return new Filme(nomeFilme, descricaoFilme, orcamento, dataFilme);

        //return novoDiretor;
    }

    public void setfilmeService(Filme filme) {
        filmeList.add(filme);
    }

    public void listarFilmes() {
        if (filmeList.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.\n");
            return;
        }
        System.out.println(" + Lista de Filmes");
        System.out.println("------------------------------");
        for (Filme filme : filmeList) {
            System.out.println("Nome: " + filme.getNomeFilme() + " | Data de lançamento: "  + filme.getDataLancamento());
            System.out.println("Descrição: " + filme.getDescricaoFilme());
            System.out.println("------------------------------");
        }
     }

    @Override
    public String toString() {
        return "FilmeService{" +
                "filmeList=" + filmeList +
                '}';
    }

    public Filme pesquisarFilmeNome(String nomeFilme) {
        for (Filme filme : filmeList) {
            if (filme.getNomeFilme().equalsIgnoreCase(nomeFilme)) {
                return filme;
            }
        }
        return null;
    }
}
