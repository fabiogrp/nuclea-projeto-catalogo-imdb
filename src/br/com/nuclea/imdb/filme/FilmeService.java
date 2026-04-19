package br.com.nuclea.imdb.filme;

public class FilmeService {



    public Filme pesquisarFilmeNome(String nomeFilme){
        for (Filme filme : filmes){
            if(filme.getNomeFilme().equalsIgnoreCase(nomeFilme)){
                return filme;
            }
        }
        return null;
    }

}
