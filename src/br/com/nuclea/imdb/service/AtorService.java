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
            System.out.println("O valor do cachê não pode ser negativo.");
            return;
        }

        AtorMock.adicionarAtor(novoAtor);
        System.out.println("Ator cadastrado com sucesso!");
    }

    public static void listarAtores() {
        List<Ator> atores = AtorMock.getListaAtores();
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
        } else {
            for (Ator ator : atores) {
                System.out.println(ator);
            }
        }
    }
}