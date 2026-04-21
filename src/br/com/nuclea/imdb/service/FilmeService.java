package br.com.nuclea.imdb.service;

import br.com.nuclea.imdb.filme.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {
    private List<Filme> filmeList;

    public FilmeService() {
        this.filmeList = new ArrayList<>();
    }

    public void setfilmeSerive(Filme filme) {
        filmeList.add(filme);
    }


    public Filme pesquisarFilmeNome(String nomeFilme){
        for (Filme filme : filmeList){
            if(filme.getNomeFilme().equalsIgnoreCase(nomeFilme)){
                return filme;
            }
        }
        return null;
    }

}
