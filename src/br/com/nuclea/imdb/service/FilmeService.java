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

        System.out.print("Nome: ");
        String nomeFilme = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricaoFilme = scanner.nextLine();

        System.out.print("Data de lançamento (dd/mm/aaaa): ");
        String dataFilme = scanner.nextLine();

//        scanner.nextLine();

        System.out.print("Orçamento R$: ");
        double orcamento = scanner.nextDouble();

        //scanner.close();

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
            System.out.println("ID: " + filme.getId() + " | Nome: " + filme.getNomeFilme() + " | Data de lançamento: "  + filme.getDataLancamento());
            System.out.println("Descrição: " + filme.getDescricaoFilme());
            System.out.println("------------------------------");
        }
     }

    public List<Filme> pesquisarFilmeNome(String nomeFilme) {
        List<Filme> filmesEncontrados = new ArrayList<>();

        for (Filme filme : filmeList) {
            if (filme.getNomeFilme().toLowerCase().contains(nomeFilme.toLowerCase())) {
                filmesEncontrados.add(filme);
            }
        }
        return filmesEncontrados;
    }

    public void detalhesFilme(Filme filme) {
        System.out.println("---Detalhes do Filme---");
        System.out.println("------------------------------");
        System.out.println("Nome: " + filme.getNomeFilme() + " | Data de lançamento: " + filme.getDataLancamento() + " | Orçamento R$: " + filme.getOrcamentoFilme());
        System.out.println("Descrição: " + filme.getDescricaoFilme());
        System.out.println("Diretor(a): " + filme.getDiretorFilme());
        System.out.println("Ator(es): " + filme.getAtores());
    }

    @Override
    public String toString() {
        return "FilmeService{" +
                "filmeList=" + filmeList +
                '}';
    }
}
