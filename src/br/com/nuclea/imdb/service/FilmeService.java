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
}
