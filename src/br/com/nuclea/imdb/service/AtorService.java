package br.com.nuclea.imdb.service;

import br.com.nuclea.imdb.pessoa.Ator;
import br.com.nuclea.imdb.repository.AtorMock;

import java.util.List;

public class AtorService {

    public Ator buscarPorNome(String nome) {
        for (Ator ator : AtorMock.getListaAtores()) {
            if (ator.getNome().equalsIgnoreCase(nome)) return ator;
        }
        return null;
    }

    public void cadastrarAtor(Ator novoAtor) {
        if (novoAtor.getNome() == null || novoAtor.getNome().isBlank()) {
            System.out.println("O nome do ator não pode estar vazio.");
            return;
        }

        if (novoAtor.getCache() != null && novoAtor.getCache() < 0) {
            System.out.println("O valor do cache não pode ser negativo.");
            return;
        }

        AtorMock.adicionarAtor(novoAtor);
        System.out.printf("\nAtor/Atriz %s cadastrado(a) com sucesso!\n", novoAtor.getNome());
    }

    public static void listarAtores() {
        List<Ator> atores = AtorMock.getListaAtores();
        if (atores.isEmpty()) {
            System.out.println("\nNenhum ator cadastrado.\n");
            return;
        }
        System.out.println(" + Lista de Atores");
        System.out.println("------------------------------");
        for (Ator ator : atores) {
            System.out.println(ator);
            System.out.println("------------------------------");
        }
    }
}