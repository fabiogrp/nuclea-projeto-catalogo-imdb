package br.com.nuclea.imdb.service;

import br.com.nuclea.imdb.filme.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {
    private List<Filme> filmeList;

    public FilmeService() {
        this.filmeList = new ArrayList<>();
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
            System.out.println("------------------------------");
        }
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
