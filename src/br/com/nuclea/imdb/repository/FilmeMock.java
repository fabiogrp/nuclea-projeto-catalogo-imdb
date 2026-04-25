package br.com.nuclea.imdb.repository;

import br.com.nuclea.imdb.filme.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeMock {

    private static final List<Filme> listaFilmes = new ArrayList<>();

    static {
        listaFilmes.add(new Filme("A Hora do Mal", "Terror", 2000000000,"23/01/2025"));
        listaFilmes.add(new Filme("Magnólia", "Drama", 300000000,"07/10/1999"));
        listaFilmes.add(new Filme("Céu e Inferno", "Suspense", 400000000,"23/01/1963"));
    }

    public static List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public static void adicionarFilme(Filme filme) {
        listaFilmes.add(filme);
    }
}
