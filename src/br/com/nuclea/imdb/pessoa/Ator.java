package br.com.nuclea.imdb.pessoa;

import br.com.nuclea.imdb.repository.AtorMock;

public class Ator extends Pessoa {

    private Double cache;
    private static int contador;
    private int id;


    public Ator(String nome, int idade, Double cache) {
        super(nome, idade);
        this.cache = cache;
        this.id = ++contador;
    }

    public void setCache(Double cache) {}

    public Double getCache() {
        return cache;
    }

    public int getId() {
        return id;
    }

    public Ator buscarPorNome(String nome) {
        for (Ator ator : AtorMock.getListaAtores()) {
            if (ator.getNome().equalsIgnoreCase(nome)) return ator;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.id + " | " + getNome();
    }
}