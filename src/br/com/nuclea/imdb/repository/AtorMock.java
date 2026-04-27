package br.com.nuclea.imdb.repository;

import br.com.nuclea.imdb.pessoa.Ator;

import java.util.ArrayList;
import java.util.List;

public class AtorMock {
    private static final List<Ator> listaAtores = new ArrayList<>();

    static {
        listaAtores.add(new Ator("Fernanda Montenegro", 91, 50000.0));
        listaAtores.add(new Ator( "Wagner Moura", 51,  80000.0));
        listaAtores.add(new Ator("Megan Fox", 47, 120000.0));
    }

    public static List<Ator> getListaAtores() {
        return listaAtores;
    }

    public static void adicionarAtor(Ator ator) {
        listaAtores.add(ator);
    }
}
